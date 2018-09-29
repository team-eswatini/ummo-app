package com.example.sakkhispot.discovery;

public class Service {
    public String serviceName;
    public String serviceRquirement;
    public String serviceTime;
    public String serviceLevelAgreement;
    public String serviceCost;

    public Service(String serviceName, String serviceRquirement, String serviceTime, String serviceLevelAgreement,
                   String serviceCost){

        this.serviceName= serviceName;
        this.serviceRquirement= serviceRquirement;
        this.serviceTime= serviceTime;
        this.serviceLevelAgreement= serviceLevelAgreement;
        this.serviceCost= serviceCost;
    }
}
