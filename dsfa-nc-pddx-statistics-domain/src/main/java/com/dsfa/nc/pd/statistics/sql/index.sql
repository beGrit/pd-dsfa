#namespace("statistics.sql")
    ### 统计没有被删除的课程数量
    #sql("countClasses")
        select
               count(*)
        from
             teas_jwgl_bjgl bjgl
        where
              bjgl.ds_deleted = '0' and bjgl.enabled = '0'
    #end

    ### 统计没有被删除的学生数量
    #sql("countStudents")
        select
               count(*)
        from
             nc_class_student stu
        where
              stu.ds_deleted = '0' and stu.enabled = '0'
    #end

    ### 统计没有被删除的教师数量
    #sql("countTeachers")
        select
               count(*)
        from
             nc_teacher teacher
        where
              teacher.ds_deleted = '0' and teacher.enabled = '0'
    #end
#end