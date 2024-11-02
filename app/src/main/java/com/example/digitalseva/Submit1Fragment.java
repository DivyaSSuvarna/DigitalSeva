package com.example.digitalseva;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
public class Submit1Fragment extends Fragment implements View.OnClickListener{
    ImageView uploadImage, uploadVideo;
    Button submitButton;
    EditText uploadName, uploadState, uploadDistrict, uploadAddress, uploadPhone, uploadComplaint;
    String imageURL = "", videoURL = "";
    Uri uri = null, videoUri = null;
    public Submit1Fragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit1, container, false);
        uploadImage = view.findViewById(R.id.uploadImage);
        uploadVideo = view.findViewById(R.id.uploadVideo);
        uploadName = view.findViewById(R.id.uploadName);
        uploadState = view.findViewById(R.id.uploadState);
        uploadDistrict = view.findViewById(R.id.uploadDistrict);
        uploadAddress = view.findViewById(R.id.uploadAddress);
        uploadPhone = view.findViewById(R.id.uploadPhone);
        uploadComplaint = view.findViewById(R.id.uploadComplaint);
        submitButton = view.findViewById(R.id.submitButton);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);
                        } else {
                            Toast.makeText(getContext(), "No image selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        ActivityResultLauncher<Intent> videoPickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            videoUri = data.getData();
                        } else {
                            Toast.makeText(getContext(), "No video selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoPicker = new Intent(Intent.ACTION_PICK);
                videoPicker.setType("video/*");
                videoPickerLauncher.launch(videoPicker);
            }
        });

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

        return view;
    }

    public void submitData() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

        if (uri != null) {
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images")
                    .child(uri.getLastPathSegment());

            storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!uriTask.isComplete()) ;
                    Uri urlImage = uriTask.getResult();
                    imageURL = urlImage.toString();
                    uploadData();
                    dialog.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Image upload failed", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            uploadData();
            dialog.dismiss();
        }

        if (videoUri != null) {
            StorageReference videoReference = FirebaseStorage.getInstance().getReference().child("videos")
                    .child(videoUri.getLastPathSegment());

            videoReference.putFile(videoUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> videoUriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!videoUriTask.isComplete()) ;
                    Uri urlVideo = videoUriTask.getResult();
                    videoURL = urlVideo.toString();
                    uploadData();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "Video upload failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void uploadData() {
        String name = uploadName.getText().toString();
        String state = uploadState.getText().toString();
        String district = uploadDistrict.getText().toString();
        String address = uploadAddress.getText().toString();
        String phone = uploadPhone.getText().toString();
        String complaint = uploadComplaint.getText().toString();

        DataClass dataClass = new DataClass(name, state, district, address, phone, complaint, imageURL, videoURL);

        FirebaseDatabase.getInstance().getReference("water complaints").child(name)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Complaint registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {

    }
}
