package com.example.digitalseva;
public class DataClass {
    private String dataName;
    private String dataState;
    private String dataDistrict;
    private String dataAddress;
    private String dataPhone;
    private String dataComplaint;
    private String dataImage;
    private String dataVideo;


    public String getDataName() {
        return dataName;
    }

    public String getDataState() {
        return dataState;
    }
    public String getDataDistrict() {
        return dataDistrict;
    }
    public String getDataAddress() {
        return dataAddress;
    }
    public String getDataPhone() {
        return dataPhone;
    }

    public String getDataComplaint() {
        return dataComplaint;
    }

    public String getDataImage() {
        return dataImage;
    }
    public String getDataVideo() {
        return dataVideo;
    }

    public DataClass(String dataName, String dataState, String dataDistrict,String dataAddress,String dataPhone,String dataComplaint, String dataImage,String dataVideo) {
        this.dataName = dataName;
        this.dataState = dataState;
        this.dataDistrict = dataDistrict;
        this.dataAddress = dataAddress;
        this.dataPhone = dataPhone;
        this.dataComplaint = dataComplaint;
        this.dataImage = dataImage;
        this.dataVideo = dataVideo;
    }
}
