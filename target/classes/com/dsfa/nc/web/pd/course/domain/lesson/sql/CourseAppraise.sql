#namespace("csml.lsf.appraise")
    ### 获取所有有效的评价
    #sql ("selectAllAppraise")
        select * from csml_lsf_appraise where ds_deleted = '0'
    #end
#end