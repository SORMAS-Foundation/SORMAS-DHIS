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
package com.mirabilia.org.hzi.sormas.cases.personRecords;

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import com.mirabilia.org.hzi.sormas.cases.CasesData.personCasesUtilityClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathew Official
 */
public class personCasesExtractor {

    public static String SormasCasePull(String lev) throws ClassNotFoundException {
        SimpleDateFormat frnmt = new SimpleDateFormat("yyyy-MM-dd");
        String err_ = "";

        try {

            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            if ("2".equals(lev)) {
                //System.out.println("1111111111111111");
                pa = cox.prepareStatement(sql.getPersons_Record_to_TrackEntity);
            }
            if ("3".equals(lev)) {
             //   pa = cox.prepareStatement(sql.getSROMAS_district_Aggregate_AllCases);
            }
            if ("4".equals(lev)) {
              //  pa = cox.prepareStatement(sql.getSROMAS_community_PG);
            }
            if ("5".equals(lev)) {
             //   pa = cox.prepareStatement(sql.getSROMAS_hf_PG);
            }

            ra = pa.executeQuery();
            boolean noBreak = true;
            while (ra.next()) {
                noBreak = false;

                personCasesUtilityClass.setAddress(ra.getString("address_idx"));
                personCasesUtilityClass.setAddtionaldetails(ra.getString("additionaldetails"));
                personCasesUtilityClass.setApproximateage(ra.getString("Approximateage"));

                    personCasesUtilityClass.setApproximate_Age_Reference_Date(ra.getString("ApproximateAgeReferenceDate"));
                
                personCasesUtilityClass.setApproximateagetype(ra.getString("Approximateagetype"));
                personCasesUtilityClass.setArmedforcesrelationtype(ra.getString("Armedforcesrelationtype"));
                personCasesUtilityClass.setBirthcountry_Id(ra.getString("Birthcountry_id"));

                if (null != ra.getString("Birthdate_dd")) {
                    String dx = ra.getString("Birthdate_dd");
                    personCasesUtilityClass.setBirthdate(dx.substring(0, dx.indexOf(" ")));
                }
                
                if (null != ra.getString("Birthdate_mm")) {
                    String dx = ra.getString("Birthdate_mm");
                    personCasesUtilityClass.setBirthdate_Month(dx.substring(0, dx.indexOf(" ")));
                }
                
                if (null != ra.getString("Birthdate_yyyy")) {
                    String dx = ra.getString("Birthdate_yyyy");
                    personCasesUtilityClass.setBirthdate_Year(dx.substring(0, dx.indexOf(" ")));
                }
                personCasesUtilityClass.setBirthname(ra.getString("Birthname"));
                personCasesUtilityClass.setBirthweight(ra.getString("Birthweight"));
                personCasesUtilityClass.setBurialconductor(ra.getString("Burialconductor"));
                
                    personCasesUtilityClass.setBurialdate(ra.getString("Burialdate"));
                personCasesUtilityClass.setBurial_Place_Description(ra.getString("BurialPlaceDescription"));
                personCasesUtilityClass.setCause_of_Death(ra.getString("CauseofDeath"));
                personCasesUtilityClass.setCause_of_Death_Details(ra.getString("CauseofDeathDetails"));
                personCasesUtilityClass.setCause_of_Death_Disease(ra.getString("CauseofDeathDisease"));
                if (null != ra.getString("Changedate")) {
                    String dx = ra.getString("Changedate");
                    personCasesUtilityClass.setChangedate(dx.substring(0, dx.indexOf(" ")));
                }
                if (null != ra.getString("Changedateofembeddedlists")) {
                    String dx = ra.getString("Changedateofembeddedlists");
                    personCasesUtilityClass.setChangedateofembeddedlists(dx.substring(0, dx.indexOf(" ")));
                }
                personCasesUtilityClass.setCitizenship_Id(ra.getString("Citizenship_id"));
                personCasesUtilityClass.setCovidcodedelivered(ra.getString("Covidcodedelivered"));
                if (null != ra.getString("Creationdate")) {
                    String dx = ra.getString("Creationdate");
                    personCasesUtilityClass.setCreationdate(dx.substring(0, dx.indexOf(" ")));
                }
               
                    personCasesUtilityClass.setDeathdate(ra.getString("Deathdate"));
                personCasesUtilityClass.setDeath_Place_Description(ra.getString("DeathPlaceDescription"));
                personCasesUtilityClass.setDeath_Place_Type(ra.getString("DeathPlaceType"));
                personCasesUtilityClass.setEducation_Details(ra.getString("EducationDetails"));
                personCasesUtilityClass.setEducation_Type(ra.getString("EducationType"));
                personCasesUtilityClass.setExternalid(ra.getString("PERSONexternalid"));
                personCasesUtilityClass.setExternaltoken(ra.getString("Externaltoken"));
                personCasesUtilityClass.setFathersname(ra.getString("Fathersname"));
                personCasesUtilityClass.setFirstname(ra.getString("Firstname"));
                personCasesUtilityClass.setGestationageatbirth(ra.getString("Gestationageatbirth"));
                personCasesUtilityClass.setHascovidapp(ra.getString("Hascovidapp"));
                personCasesUtilityClass.setMothersmaidenname(ra.getString("Mothersmaidenname"));
                personCasesUtilityClass.setMothersname(ra.getString("Mothersname"));
                personCasesUtilityClass.setNameofguardians(ra.getString("namesofguardians"));
                personCasesUtilityClass.setNationalhealth_Id(ra.getString("Nationalhealthid"));
                personCasesUtilityClass.setNickname(ra.getString("Nickname"));
                personCasesUtilityClass.setOccupationdetails(ra.getString("Occupationdetails"));
                personCasesUtilityClass.setOccupationtype(ra.getString("Occupationtype"));
                personCasesUtilityClass.setOthersalutation(ra.getString("Othersalutation"));
                personCasesUtilityClass.setPassportnumber(ra.getString("Passportnumber"));
                personCasesUtilityClass.setPlaceofbirthcommunity_Id(ra.getString("Placeofbirthcommunity_id"));
                personCasesUtilityClass.setPlaceofbirthdistrict_Id(ra.getString("Placeofbirthdistrict_id"));
                personCasesUtilityClass.setPlaceofbirthfacilitydetails(ra.getString("Placeofbirthfacilitydetails"));
                personCasesUtilityClass.setPlaceofbirthfacility_Id(ra.getString("Placeofbirthfacility_id"));
                personCasesUtilityClass.setPlaceofbirthfacilitytype(ra.getString("Placeofbirthfacilitytype"));
                personCasesUtilityClass.setPlaceofbirthregion_Id(ra.getString("Placeofbirthregion_id"));
                personCasesUtilityClass.setPresentcondition(ra.getString("Presentcondition"));
                personCasesUtilityClass.setSalutation(ra.getString("Salutation"));
                personCasesUtilityClass.setSex(ra.getString("Sex"));
                personCasesUtilityClass.setSormas_System_Period(ra.getString("sys_Period"));
                personCasesUtilityClass.setSRM_Uuid(ra.getString("Uuid"));
                personCasesUtilityClass.setSymptomjournalstatus(ra.getString("Symptomjournalstatus"));
                personCasesUtilityClass.setExternal_id(ra.getString("externalid_region"));
                personCasesUtilityClass.setC_id(ra.getString("id_case"));
                
                personSender.jsonDHISSender();
                

            }
            
            if(noBreak){
                err_ = "No new record found on SORMAS System";
                System.out.println("DEBUGGER 45WERF345DFG: No record found on SORMAS System");
            }

        } catch (SQLException ex) {
            Logger.getLogger(personCasesExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return err_;

    }
}
