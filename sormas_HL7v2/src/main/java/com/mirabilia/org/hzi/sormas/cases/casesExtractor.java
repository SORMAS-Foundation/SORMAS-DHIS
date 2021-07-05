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
package com.mirabilia.org.hzi.sormas.cases;

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.aggregate.AggregrateController;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
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
public class casesExtractor {

    public static void SormasCasePull(String lev) throws ClassNotFoundException {
        SimpleDateFormat frnmt = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            if ("2".equals(lev)) {
                //System.out.println("1111111111111111");
                pa = cox.prepareStatement(sql.getPErsons_Record_to_TrackEntity);
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
            while (ra.next()) {

                casesUtilityClass.setAddress(ra.getString("address_id"));
                casesUtilityClass.setAddtionaldetails(ra.getString("additionaldetails"));
                casesUtilityClass.setApproximateage(ra.getString("Approximateage"));

                    casesUtilityClass.setApproximate_Age_Reference_Date(ra.getString("ApproximateAgeReferenceDate"));
                
                casesUtilityClass.setApproximateagetype(ra.getString("Approximateagetype"));
                casesUtilityClass.setArmedforcesrelationtype(ra.getString("Armedforcesrelationtype"));
                casesUtilityClass.setBirthcountry_Id(ra.getString("Birthcountry_id"));

                if (null != ra.getString("Birthdate_dd")) {
                    String dx = ra.getString("Birthdate_dd");
                    casesUtilityClass.setBirthdate(dx.substring(0, dx.indexOf(" ")));
                }
                
                if (null != ra.getString("Birthdate_mm")) {
                    String dx = ra.getString("Birthdate_mm");
                    casesUtilityClass.setBirthdate_Month(dx.substring(0, dx.indexOf(" ")));
                }
                
                if (null != ra.getString("Birthdate_yyyy")) {
                    String dx = ra.getString("Birthdate_yyyy");
                    casesUtilityClass.setBirthdate_Year(dx.substring(0, dx.indexOf(" ")));
                }
                casesUtilityClass.setBirthname(ra.getString("Birthname"));
                casesUtilityClass.setBirthweight(ra.getString("Birthweight"));
                casesUtilityClass.setBurialconductor(ra.getString("Burialconductor"));
                
                    casesUtilityClass.setBurialdate(ra.getString("Burialdate"));
                casesUtilityClass.setBurial_Place_Description(ra.getString("BurialPlaceDescription"));
                casesUtilityClass.setCause_of_Death(ra.getString("CauseofDeath"));
                casesUtilityClass.setCause_of_Death_Details(ra.getString("CauseofDeathDetails"));
                casesUtilityClass.setCause_of_Death_Disease(ra.getString("CauseofDeathDisease"));
                if (null != ra.getString("Changedate")) {
                    String dx = ra.getString("Changedate");
                    casesUtilityClass.setChangedate(dx.substring(0, dx.indexOf(" ")));
                }
                if (null != ra.getString("Changedateofembeddedlists")) {
                    String dx = ra.getString("Changedateofembeddedlists");
                    casesUtilityClass.setChangedateofembeddedlists(dx.substring(0, dx.indexOf(" ")));
                }
                casesUtilityClass.setCitizenship_Id(ra.getString("Citizenship_id"));
                casesUtilityClass.setCovidcodedelivered(ra.getString("Covidcodedelivered"));
                if (null != ra.getString("Creationdate")) {
                    String dx = ra.getString("Creationdate");
                    casesUtilityClass.setCreationdate(dx.substring(0, dx.indexOf(" ")));
                }
               
                    casesUtilityClass.setDeathdate(ra.getString("Deathdate"));
                casesUtilityClass.setDeath_Place_Description(ra.getString("DeathPlaceDescription"));
                casesUtilityClass.setDeath_Place_Type(ra.getString("DeathPlaceType"));
                casesUtilityClass.setEducation_Details(ra.getString("EducationDetails"));
                casesUtilityClass.setEducation_Type(ra.getString("EducationType"));
                casesUtilityClass.setExternalid(ra.getString("Externalid"));
                casesUtilityClass.setExternaltoken(ra.getString("Externaltoken"));
                casesUtilityClass.setFathersname(ra.getString("Fathersname"));
                casesUtilityClass.setFirstname(ra.getString("Firstname"));
                casesUtilityClass.setGestationageatbirth(ra.getString("Gestationageatbirth"));
                casesUtilityClass.setHascovidapp(ra.getString("Hascovidapp"));
                casesUtilityClass.setMothersmaidenname(ra.getString("Mothersmaidenname"));
                casesUtilityClass.setMothersname(ra.getString("Mothersname"));
                casesUtilityClass.setNameofguardians(ra.getString("namesofguardians"));
                casesUtilityClass.setNationalhealth_Id(ra.getString("Nationalhealthid"));
                casesUtilityClass.setNickname(ra.getString("Nickname"));
                casesUtilityClass.setOccupationdetails(ra.getString("Occupationdetails"));
                casesUtilityClass.setOccupationtype(ra.getString("Occupationtype"));
                casesUtilityClass.setOthersalutation(ra.getString("Othersalutation"));
                casesUtilityClass.setPassportnumber(ra.getString("Passportnumber"));
                casesUtilityClass.setPlaceofbirthcommunity_Id(ra.getString("Placeofbirthcommunity_id"));
                casesUtilityClass.setPlaceofbirthdistrict_Id(ra.getString("Placeofbirthdistrict_id"));
                casesUtilityClass.setPlaceofbirthfacilitydetails(ra.getString("Placeofbirthfacilitydetails"));
                casesUtilityClass.setPlaceofbirthfacility_Id(ra.getString("Placeofbirthfacility_id"));
                casesUtilityClass.setPlaceofbirthfacilitytype(ra.getString("Placeofbirthfacilitytype"));
                casesUtilityClass.setPlaceofbirthregion_Id(ra.getString("Placeofbirthregion_id"));
                casesUtilityClass.setPresentcondition(ra.getString("Presentcondition"));
                casesUtilityClass.setSalutation(ra.getString("Salutation"));
                casesUtilityClass.setSex(ra.getString("Sex"));
                casesUtilityClass.setSormas_System_Period(ra.getString("sys_Period"));
                casesUtilityClass.setSRM_Uuid(ra.getString("Uuid"));
                casesUtilityClass.setSymptomjournalstatus(ra.getString("Symptomjournalstatus"));//r.externalid
                casesUtilityClass.setExternal_id(ra.getString("externalid_region"));
                casesUtilityClass.setC_id(ra.getString("id_case"));
                
                caseSender.jsonDHISSender();
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
