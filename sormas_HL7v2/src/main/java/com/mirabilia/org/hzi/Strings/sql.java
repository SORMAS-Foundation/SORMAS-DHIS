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
package com.mirabilia.org.hzi.Strings;

/**
 *
 * @author Mathew Official
 */
public class sql {
   
    

    public static String count_all_from_source= "SELECT * FROM raw_ r WHERE r.`level` = 2;";
    public static String count_all_from_destination = "SELECT * FROM sormas_local d WHERE d.`level` = 2";
    public static String count_matched = "SELECT * FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";
    
    public static String count_all_from_source_no= "SELECT count(*) FROM raw_ r WHERE r.`level` = 2;";
    public static String count_all_from_destination_no = "SELECT count(*) FROM sormas_local d WHERE d.`level` = 2";
    public static String count_matched_no = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";
    public static String count_matched_name = "SELECT d.namex FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 2";
    
    public static String count_all_byparent_from_source_no= "SELECT count(*) FROM raw_ r WHERE r.`level` = ? and r.parent_id = ?";
    public static String count_all_byparent_from_destination_no = "SELECT count(*) FROM sormas_local d WHERE d.`level` = ? and r.parent_id = ?";
    public static String count__byparent_matched_no = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = ? and r.parent_id = ?";
    public static String count__parent_matched_name = "SELECT d.namex FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = ? and r.parent_id = ?";
    
    public static String count_by_level_using_parent = "select count(*) from sormas_local s where s.parent_id = (select s.uid from sormas_local s where s.namex like ?  and level = 2) and level = 3";
    public static String count_by_level_using_parent_source_q1 = "select uuid from raw_ r where r.name like ? and level = 2;";
    public static String count_by_level_using_parent_source_q2 = "select count(*) from raw_ s where s.path_parent like ? and level = 3";
    public static String count_by_level_using_parent_source_name = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.namex like ?  and level = 2)";
    public static String count_by_level_using_parent_source_name_xx = "SELECT d.namex FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 3 and d.parent_id = (select sx.uid from sormas_local sx where sx.namex like ?  and level = 2)";
    
    public static String L4_count_by_level_using_parent = "select count(*) from sormas_local s where s.parent_id = (select s.uid from sormas_local s where s.namex like ?  and level = 3) and level = 4";
    public static String L4_count_by_level_using_parent_source_q1 = "select uuid from raw_ r where r.name like ? and level = 3;";
    public static String L4_count_by_level_using_parent_source_q2 = "select count(*) from raw_ s where s.path_parent like ? and level = 4";
    public static String L4_count_by_level_using_parent_source_name = "SELECT count(*) FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` =43 and d.parent_id = (select sx.uid from sormas_local sx where sx.namex like ?  and level = 3)";
    public static String L4_count_by_level_using_parent_source_name_xx = "SELECT d.namex FROM raw_ r inner JOIN sormas_local d ON (r.UUID = d.externalid) WHERE r.`level` = 4 and d.parent_id = (select sx.uid from sormas_local sx where sx.namex like ?  and level = 3)";
    


    public static String count_unmatched_at_destination = "SELECT * FROM sormas_local d WHERE d.uid not IN (SELECT dd.uid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND d.`level` = 2";
    public static String count_unmatched_at_destination_no = "SELECT COUNT(*) FROM sormas_local d WHERE d.uid not IN (SELECT dd.uid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND d.`level` = 2";
    public static String count_unmatched_at_source = "SELECT * FROM raw_ rr WHERE rr.uuid not IN (SELECT r.uuid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND rr.`level` = 2";
    public static String count_unmatched_at_source_no = "SELECT COUNT(*) FROM raw_ rr WHERE rr.uuid not IN (SELECT r.uuid FROM raw_ r inner JOIN sormas_local dd ON (r.UUID = dd.externalid) WHERE r.`level` = 2) AND rr.`level` = 2";

    
}
