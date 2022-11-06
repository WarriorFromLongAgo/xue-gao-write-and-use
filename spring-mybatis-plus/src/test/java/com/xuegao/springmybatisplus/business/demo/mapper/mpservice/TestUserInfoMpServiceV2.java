package com.xuegao.springmybatisplus.business.demo.mapper.mpservice;

import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserInfoMpServiceV2 {

    @Autowired
    private UserInfoMpServiceV2 userInfoMpServiceV2;

    @Test
    public void testDisable() {

        // userInfoMpServiceV2.lambdaQuery().
        // userInfoMpServiceV2.lambdaUpdate().update();
        // userInfoMpServiceV2.update(new UserInfo(), Wrappers.lambdaUpdate())
        // userInfoMpServiceV2.lambdaQuery();
        // userInfoMpServiceV2.query();
        // userInfoMpServiceV2.update().in().update();

        // userInfoMpServiceV2.disableService();
    }

    @Test
    public void testDisable2() {
        userInfoMpServiceV2.disableService();
    }

    @Test
    public void testMpUpdateService() {
        userInfoMpServiceV2.mpUpdateService();
        // ==>  Preparing: UPDATE user_info SET username=?,password=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username=2022-11-06 11:52:28(String), null, 0(String), 2022-11-06T11:52:28.362(LocalDateTime), null, 1(Integer)
        // <==    Updates: 1
    }

    @Test
    public void testMpUpdateBatchServiceNoTransactional() {
        userInfoMpServiceV2.mpUpdateBatchServiceNoTransactional();
        // 2022-11-06 11:48:18.792  WARN 16756 --- [           main] c.x.m.mpservice.AbstractMpServiceV2      : SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@244418a] Transaction not enabled
        // Creating a new SqlSession
        // SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@43acd79e] was not registered for synchronization because synchronization is not active
        // JDBC Connection [HikariProxyConnection@766621271 wrapping com.mysql.cj.jdbc.ConnectionImpl@1943c1f2] will not be managed by Spring
        // ==>  Preparing: UPDATE user_info SET username=?,password=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username11=2022-11-06 11:48:18(String), null, 0(String), 2022-11-06T11:48:18.805(LocalDateTime), null, 1(Integer)
        // <==    Updates: 1
        // Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@43acd79e]
        // Creating a new SqlSession
        // SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6968bcec] was not registered for synchronization because synchronization is not active
        // 2022-11-06 11:48:19.131 DEBUG 16756 --- [           main] o.s.jdbc.datasource.DataSourceUtils      : Fetching JDBC Connection from DataSource
        // JDBC Connection [ HikariProxyConnection @242762528 wrapping com.mysql.cj.jdbc.ConnectionImpl@1943c1f2] will not be managed by Spring
        // ==>  Preparing: UPDATE user_info SET username=?,password=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username22=2022-11-06 11:48:18(String), null, 0(String), 2022-11-06T11:48:19.129(LocalDateTime), null, 2(Integer)
        // <==    Updates: 1
        // Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6968bcec]
    }

    @Test
    public void testMpUpdateBatchServiceHaveTransactional() {
        userInfoMpServiceV2.mpUpdateBatchServiceHaveTransactional();
        // Creating a new SqlSession
        // Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@71adfedd]
        // JDBC Connection [ HikariProxyConnection @278166606 wrapping com.mysql.cj.jdbc.ConnectionImpl@3eb3232b] will be managed by Spring
        // ==>  Preparing: UPDATE user_info SET username=?,password=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username11=2022-11-06 11:50:42(String), null, 0(String), 2022-11-06T11:50:42.466(LocalDateTime), null, 1(Integer)
        // <==    Updates: 1
        // Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@71adfedd]
        // Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@71adfedd] from current transaction
        // ==>  Preparing: UPDATE user_info SET username=?,password=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username22=2022-11-06 11:50:42(String), null, 0(String), 2022-11-06T11:50:42.526(LocalDateTime), null, 2(Integer)
        // <==    Updates: 1
        // Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@71adfedd]
    }

    @Test
    public void testMpUpdateFilterNullService() {
        userInfoMpServiceV2.mpUpdateFilterNullService();
        // ==>  Preparing: UPDATE user_info SET username=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username=2022-11-06 11:53:11(String), 0(String), 2022-11-06T11:53:11.303(LocalDateTime), null, 2(Integer)
        // <==    Updates

    }

    @Test
    public void testMpUpdateBatchFilterNullServiceHaveTransactional() {
        userInfoMpServiceV2.mpUpdateBatchFilterNullServiceHaveTransactional();
        // Creating a new SqlSession
        // Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@38b3f208]
        // JDBC Connection [ HikariProxyConnection @1969925628 wrapping com.mysql.cj.jdbc.ConnectionImpl@75156240] will be managed by Spring
        // ==>  Preparing: UPDATE user_info SET username=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username11=2022-11-06 11:54:48(String), 0(String), 2022-11-06T11:54:48.250(LocalDateTime), null, 1(Integer)
        // 2022-11-06 11:54:48.307 DEBUG 13056 --- [l-1 housekeeper] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Pool stats (total=1, active=1, idle=0, waiting=0)
        // <==    Updates: 1
        // Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@38b3f208]
        // Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@38b3f208] from current transaction
        // ==>  Preparing: UPDATE user_info SET username=?,update_by=?,update_time=?,trace_id=? WHERE (id = ?)
        // ==> Parameters: username22=2022-11-06 11:54:48(String), 0(String), 2022-11-06T11:54:48.312(LocalDateTime), null, 2(Integer)
        // <==    Updates: 1
        // Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@38b3f208]

    }

    @Test
    public void testTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(11);
        userInfo.setUsername("setUsername11111");
        userInfo.setPassword("setPassword111111");
        userInfo.setCreateBy("setCreateBy1111111");
        userInfo.setUpdateBy("setUpdateBy1111111");
        userInfoMpServiceV2.test(userInfo);
    }
}
