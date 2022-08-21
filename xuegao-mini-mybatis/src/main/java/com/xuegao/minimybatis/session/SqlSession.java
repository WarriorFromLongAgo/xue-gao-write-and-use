package com.xuegao.minimybatis.session;

import java.io.Closeable;
import java.util.List;

public interface SqlSession extends Closeable {

    // /**
    //  * Retrieve a single row mapped from the statement key.
    //  * @param <T> the returned object type
    //  * @param statement
    //  *          the statement
    //  * @return Mapped object
    //  */
    // <T> T selectOne(String statement);
    //
    // /**
    //  * Retrieve a single row mapped from the statement key and parameter.
    //  * @param <T> the returned object type
    //  * @param statement Unique identifier matching the statement to use.
    //  * @param parameter A parameter object to pass to the statement.
    //  * @return Mapped object
    //  */
    // <T> T selectOne(String statement, Object parameter);

    /**
     * Retrieve a list of mapped objects from the statement key.
     * @param <E> the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @return List of mapped object
     */
    <E> List<E> selectList(String statement);

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.
     * @param <E> the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return List of mapped object
     */
    <E> List<E> selectList(String statement, Object parameter);

}
