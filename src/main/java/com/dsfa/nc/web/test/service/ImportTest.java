package com.dsfa.nc.web.test.service;



import com.dsfa.platform.sdk.common.kit.StrKit;
import com.dsfa.platform.sdk.common.kit.file.FileKit;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Db;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Record;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ImportTest {

    String root = "D:/project/dsfa-nc/nc-base4.0/dsfa/";
    Map<String, Record> map;



    public void dsfaRm() {
        map = Db.find("select id,dsfa_rm_id,path as \"path\",code from dsfa_rm where type_value=1 and ds_deleted = '0' AND content  IS  NULL ")
            .stream().collect(Collectors.toMap(r -> r.getStr("path"), r -> r));
        this.files();
    }

    public void files() {
        map.forEach((path, record) -> {
            String code = record.getStr("code");
            String filePath = path(code,path);
            System.out.println(filePath);
            if(FileKit.exists(filePath)){
                record.set("content",FileKit.read(filePath));
            }else{
                record.set("content","");
            }
        });
    }

    private String path(String code,String path) {
        if(StrKit.isBlank(code) || StrKit.isBlank(path)){
            return null;
        }
        String dir = path.substring(0,path.length()-code.length());
        return root+dir +"res/"+code+".md";
    }


    public void importMd() {
        System.out.println(map.size());
        Db.batchUpdate("dsfa_rm", "dsfa_rm_id", map.values().stream().collect(Collectors.toList()), 100);
    }

}
