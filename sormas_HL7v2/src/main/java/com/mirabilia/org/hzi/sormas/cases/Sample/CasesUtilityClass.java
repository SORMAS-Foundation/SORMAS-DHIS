/*
 * Copyright (c) 2021, Mathew Official
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.mirabilia.org.hzi.sormas.cases.Sample;

import com.mirabilia.org.hzi.sormas.cases.Case.*;

/**
 *
 * @author Mathew Official
 */
public class CasesUtilityClass {

    
    private static String external_id = "0";
    private static String c_id = "0";
    private static String person_id="0";
    private static String creationdate="0";
    private static String disease="0";
    private static String caseclassification="0";
    private static String outcome="0";
    private static String caseage="0";
    private static String caseorigin="0";
    private static String trackedentity_id = "0";//CaseLat
    
    private static String CaseLat = "0";
    private static String CaseLong = "0";
    
    
    private static String samplematerial="0";
    private static String lab_id="0";
    private static String pathogentestingrequested="0";
    private static String pathogentestresult="0";
    private static String fieldsampleid="0";
    private static String samplingreason="0";
    private static String labdetails="0";

    public static String getExternal_id() {
        return external_id;
    }

    public static void setExternal_id(String external_id) {
        CasesUtilityClass.external_id = external_id;
    }

    public static String getC_id() {
        return c_id;
    }

    public static void setC_id(String c_id) {
        CasesUtilityClass.c_id = c_id;
    }

    public static String getPerson_id() {
        return person_id;
    }

    public static void setPerson_id(String person_id) {
        CasesUtilityClass.person_id = person_id;
    }

    public static String getDisease() {
        return disease;
    }

    public static void setDisease(String disease) {
        CasesUtilityClass.disease = disease;
    }

    public static String getCaseclassification() {
        return caseclassification;
    }

    public static void setCaseclassification(String caseclassification) {
        CasesUtilityClass.caseclassification = caseclassification;
    }

    public static String getOutcome() {
        return outcome;
    }

    public static String getCreationdate() {
        return creationdate;
    }

    public static void setCreationdate(String creationdate) {
        CasesUtilityClass.creationdate = creationdate;
    }

    public static String getTrackedentity_id() {
        return trackedentity_id;
    }

    public static void setTrackedentity_id(String trackedentity_id) {
        CasesUtilityClass.trackedentity_id = trackedentity_id;
    }

    public static String getCaseLat() {
        return CaseLat;
    }

    public static void setCaseLat(String CaseLat) {
        CasesUtilityClass.CaseLat = CaseLat;
    }

    public static String getCaseLong() {
        return CaseLong;
    }

    public static void setCaseLong(String CaseLong) {
        CasesUtilityClass.CaseLong = CaseLong;
    }
    
    
    
    

    

    public static void setOutcome(String outcome) {
        CasesUtilityClass.outcome = outcome;
    }

    public static String getCaseage() {
        return caseage;
    }

    public static void setCaseage(String caseage) {
        CasesUtilityClass.caseage = caseage;
    }

    public static String getCaseorigin() {
        return caseorigin;
    }

    public static void setCaseorigin(String caseorigin) {
        CasesUtilityClass.caseorigin = caseorigin;
    }

    public static String getSamplematerial() {
        return samplematerial;
    }

    public static void setSamplematerial(String samplematerial) {
        CasesUtilityClass.samplematerial = samplematerial;
    }

    public static String getLab_id() {
        return lab_id;
    }

    public static void setLab_id(String lab_id) {
        CasesUtilityClass.lab_id = lab_id;
    }

    public static String getPathogentestingrequested() {
        return pathogentestingrequested;
    }

    public static void setPathogentestingrequested(String pathogentestingrequested) {
        CasesUtilityClass.pathogentestingrequested = pathogentestingrequested;
    }

    public static String getPathogentestresult() {
        return pathogentestresult;
    }

    public static void setPathogentestresult(String pathogentestresult) {
        CasesUtilityClass.pathogentestresult = pathogentestresult;
    }

    public static String getFieldsampleid() {
        return fieldsampleid;
    }

    public static void setFieldsampleid(String fieldsampleid) {
        CasesUtilityClass.fieldsampleid = fieldsampleid;
    }

    public static String getSamplingreason() {
        return samplingreason;
    }

    public static void setSamplingreason(String samplingreason) {
        CasesUtilityClass.samplingreason = samplingreason;
    }

    public static String getLabdetails() {
        return labdetails;
    }

    public static void setLabdetails(String labdetails) {
        CasesUtilityClass.labdetails = labdetails;
    }

    
    

}
