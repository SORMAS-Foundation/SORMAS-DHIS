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
package com.mirabilia.org.hzi.sormas.cases.Case;

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
    
    private static String caseLat = "0";
    private static String caseLong = "0";
    
    private static String caseuuid = "0";
    
    private static String redgion_id = "0";
    
    

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
        return caseLat;
    }

    public static void setCaseLat(String caseLat) {
        CasesUtilityClass.caseLat = caseLat;
    }

    public static String getCaseLong() {
        return caseLong;
    }

    public static void setCaseLong(String caseLong) {
        CasesUtilityClass.caseLong = caseLong;
    }

    public static String getCaseuuid() {
        return caseuuid;
    }

    public static void setCaseuuid(String caseuuid) {
        CasesUtilityClass.caseuuid = caseuuid;
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

    public static String getRedgion_id() {
        return redgion_id;
    }

    public static void setRedgion_id(String redgion_id) {
        CasesUtilityClass.redgion_id = redgion_id;
    }
    

}
