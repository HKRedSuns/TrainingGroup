package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.smartcardio.CardChannel;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具包,用于返回数据库连接对象和关闭数据库连接对象
 *
 */
public class ConnectionUtil {
    //定义连接池对象
    private static DataSource ds;

    //定义静态代码块加载配置文件
    static{
        try{
            //创建集合
            Properties pro = new Properties();
            //加载配置文件
            pro.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e){
            System.out.println("配置文件加载失败！");
            e.printStackTrace();
        }
    }

    /**
     * 定义一个h获取连接池连接的方法
     * @return 获取连接池连接
     */
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 定义一个归还连接池连接的方法
     * @param stmt  sql语句操作对象
     * @param conn  sql连接对象
     */
    public static void CloseConn(Statement stmt,Connection conn){
        CloseConn(null,stmt,conn);
    }

    /**
     * 重载
     * @param rs    结果集对象
     * @param stmt  sql语句操作对象
     * @param conn  sql连接对象
     */
    public static void CloseConn(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池对象方法
     * @return  返回连接池对象DataSource
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
