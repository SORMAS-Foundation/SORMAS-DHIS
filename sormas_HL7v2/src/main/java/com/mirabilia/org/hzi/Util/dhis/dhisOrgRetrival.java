/*
 * Copyright (c) 2020, Mathew Official
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
package com.mirabilia.org.hzi.Util.dhis;

import static com.mirabilia.org.hzi.Util.dbResolvers.gotoDB;
import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAll;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathew Official
 */
public class dhisOrgRetrival {

    public static int starter(int pg_counterd, String urll) {
        if (pg_counterd > 1) {

            String json_all = "{'pager':'233'}";

            System.out.println("XXXXX<<<<<<<<<<<<<<XXXXXXXXXXX = " + pg_counterd);
            if (json_all.isEmpty()) {
                return 0;
            } else {
                try {

                    String base_urlx = urll+"/api/organisationUnits.json?page=" + pg_counterd + "&maxLevel=4&paging=true&fields=lastUpdated%2Cid%2Cname%2CshortName%2Clevel%2Ccreated%2Cpath";
                    System.out.println(base_urlx);
                    String nxtpg_url_val = getDemAll(base_urlx);

                    gotoDB(nxtpg_url_val);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dhisOrgRetrival.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }

        }

        return pg_counterd;
    }
}
