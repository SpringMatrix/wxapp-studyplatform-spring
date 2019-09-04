package com.ysu.wxappstudyplatformspring.Dao;

import com.ysu.wxappstudyplatformspring.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminDao {
    // 添加管理员
    @Insert("insert into admin(admin_id,name,account,password) values(#{admin_id},#{name},#{account},#{password})")
    void addAdmin(Admin admin);
    // 查找所有管理员
    @Select("select * from admin")
    List<Admin> selectAllAdmin();
    // 按照ID查询指定用户
    @Select("select * from admin where admin_id =#{admin_id}")
    Admin selectByIdAdmin(String admin_id);
    // 按照账号查询指定用户
    @Select("select * from admin where account =#{account}")
    Admin selectByAccountAdmin(String admin_id);
    //管理员用户信息
    @Update("update admin set name=#{name},account=#{account},password=#{password} where admin_id=#{admin_id}")
    void updateAdmin(Admin admin);

}
