#namespace("base.sql")
    ### 查询所有并加载指定的列
    #sql ("findLoadColumns")
        select
            #for(columnName : columnNames)
                #(for.index == 0? "" : ",") #(columnName)
                    #end
        from
            #(tableName)
        where
                `ds_deleted` = '0'
    #end
#end