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
import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.Util.UtilServer;
import com.mirabilia.org.hzi.sormas.aggregate.SendToDHISServer;
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
public class SampleExtractor {

    public static void SormasSamplePull(String lev) throws ClassNotFoundException {
        SimpleDateFormat frnmt = new SimpleDateFormat("yyyy-MM-dd");

        try {
            
            UtilServer.UpgradeSORMASTable4();

            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            if ("2".equals(lev)) {
                
                pa = cox.prepareStatement(sql.getSamples);
            }
            else if ("3".equals(lev)) {
                //   pa = cox.prepareStatement(sql.getSROMAS_district_Aggregate_AllCases);
            }
            else if  ("4".equals(lev)) {
                //  pa = cox.prepareStatement(sql.getSROMAS_community_PG);
            }
            else if ("5".equals(lev)) {
                //   pa = cox.prepareStatement(sql.getSROMAS_hf_PG);
            } else {
            
            return;
            
            }

            ra = pa.executeQuery();
            while (ra.next()) {
                
                //s.samplematerial, s.lab_id, s.pathogentestingrequested, s.pathogentestresult, s.fieldsampleid,
                //s.samplingreason, s.labdetails, s.associatedcase_id\n"
                
                SampleUtilityClass.setSamplematerial(ra.getString("samplematerial"));
                SampleUtilityClass.setLab_id(ra.getString("lab_id"));
                SampleUtilityClass.setPathogentestingrequested(ra.getString("pathogentestingrequested"));
                SampleUtilityClass.setPathogentestresult(ra.getString("pathogentestresult"));
                SampleUtilityClass.setSamplingreason(ra.getString("samplingreason"));
                SampleUtilityClass.setLabdetails(ra.getString("labdetails"));
                SampleUtilityClass.setAssociatedcase_id(ra.getString("associatedcase_id"));
                
                SampleUtilityClass.setSample_id(ra.getString("id"));
                SampleUtilityClass.setSampleUuid(ra.getString("uuid"));
                
                
                SampleUtilityClass.setCaseUuid(ra.getString("associatedcase_uuid"));
                
                SampleUtilityClass.setSampleRegionID(ra.getString("reg_externalid"));
                SampleUtilityClass.setSampleExternal_Id(ra.getString("externalid"));
                String ddd = ra.getString("creationdate");
                SampleUtilityClass.setCreationdate(ddd.substring( 0, ddd.indexOf(" ")));
                
                
                //TODO: impliment coordinates
                SampleUtilityClass.setSampleCaseLat(ra.getString("reportlat"));
                SampleUtilityClass.setSampleCaseLong(ra.getString("reportlon"));
                
                SampleUtilityClass.setTrackedentity_id(ra.getString("person_external_id"));
                
                SampleSender.jsonDHISSender();

            }

        } catch (SQLException ex) {
            Logger.getLogger(SampleExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
