package com.bdqn.rongke.BBSSystem.daoImp;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bdqn.rongke.BBSSystem.Util.JDBCutil;
import com.bdqn.rongke.BBSSystem.daoInterface.DaoInterface;
import com.bdqn.rongke.BBSSystem.entity.Page;
import com.bdqn.rongke.BBSSystem.entity.Post;
import com.bdqn.rongke.BBSSystem.entity.Reply;
import com.bdqn.rongke.BBSSystem.entity.User;
import com.mysql.jdbc.PreparedStatement;

public class RegisterDaoImp implements DaoInterface{
	
	public boolean registerUser(User u) {
		//链接对象
		Connection conn=null;
		//預編譯
		PreparedStatement pst=null;
		boolean flag=false;
		try {
			conn=JDBCutil.getConnection();
			String c="insert into t_user(uname,uphone,upass) value(?,?,?)";
			pst=(PreparedStatement) conn.prepareStatement(c);
			pst.setString(1, u.getUname());
			pst.setString(2, u.getUphone());
			pst.setString(3, u.getUpass());
			//影响了几行
			int rs = pst.executeUpdate();
			if(rs!=0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, pst,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean queryUserByName(String uname) {
		// TODO Auto-generated method stub
		//链接对象
			Connection conn=null;
		//預編譯
		PreparedStatement pst=null;
		boolean flag2=false;
			try {
				conn=JDBCutil.getConnection();
				String a="select uname from t_user where uname=?";
				pst=(PreparedStatement) conn.prepareStatement(a);
				pst.setString(1,uname);
				ResultSet ry=pst.executeQuery();
				while(ry.next()) {
					flag2=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					JDBCutil.free(conn, pst,null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		return flag2;
	}

	@Override
	public User logins(String name, String pass,User u) {
		// TODO Auto-generated method stub
		
		//连接对象
		Connection conn=null;
		//预编译
		PreparedStatement pst=null;
		boolean flag=false;
		try {
			conn=JDBCutil.getConnection();
			String c="select * from t_user where (uname=? or uphone=?) and upass=?";
			pst=(PreparedStatement) conn.prepareStatement(c);
			//传参
			pst.setString(1, name);
			pst.setString(2, name);
			pst.setString(3, pass);
			ResultSet ry=pst.executeQuery();
			while(ry.next()) {
				flag=true;
				u.setId(ry.getInt("id"));
				u.setUname(ry.getString("uname"));
				u.setUpass(ry.getString("upass"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, pst,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	
	public boolean fatiezi(String biao,String nei,User u) {
		
		//连接对象
		Connection conn=null;
		//预编译
		PreparedStatement pst=null;
		//获取当前时间
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		boolean flag=false;
		try {
			conn=JDBCutil.getConnection();
			String a="insert into t_post(title,content,uid,date) value(?,?,?,?)";
			pst=(PreparedStatement) conn.prepareStatement(a);
			pst.setString(1,biao);
			pst.setString(2, nei);
			pst.setInt(3, u.getId());
			pst.setString(4, date);
			int rs = pst.executeUpdate();
			
			if(rs!=0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, pst,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return flag;
		
	}
	//分页
	@Override
	public List getindex(Page page) {
		// TODO Auto-generated method stub
		//index  首页 dao层   查询  帖子 信息
		
	
			// TODO Auto-generated method stub
			List list=new ArrayList();
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try {
				conn=JDBCutil.getConnection();
				String s="select * from (select distinct t_post.*,count(t_reply.rcontent) replyCount from t_post left join t_reply on t_post.pid=t_reply.pid group by t_post.pid) a,t_user where a.uid=t_user.id limit ?,?";
				ps=(PreparedStatement) conn.prepareStatement(s);
				ps.setInt(1, page.getPageNext());
				ps.setInt(2, page.getPageSize());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					Post post=new Post();
					post.setUid(rs.getInt("uid"));
					post.setPicPath(rs.getString("picPath"));
					post.setPid(rs.getInt("pid"));
					post.setDate(rs.getDate("date"));
					post.setBiaoti(rs.getString("title"));
					post.setYonghu(rs.getString("uname"));
					post.setNeirong(rs.getString("content"));
					post.setReplycont(rs.getInt("replyCount"));
					list.add(post);
				
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					JDBCutil.free(conn, ps,null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return list;
		}
	//总记录数
	public int getrows() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rows=0;
		try {
			conn=JDBCutil.getConnection();
			String s="select count(*) from t_post";
			ps=(PreparedStatement) conn.prepareStatement(s);
			rs=ps.executeQuery();
			while(rs.next()) {
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
		
	}

	@Override
	public Post postmess(int pid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Post p=new Post();
		
		try {
			conn=JDBCutil.getConnection();
			String s="select * from t_user,t_post where t_user.id=t_post.uid AND t_post.pid=?";
			ps=(PreparedStatement) conn.prepareStatement(s);
			
			ps.setInt(1, pid);
			rs=ps.executeQuery();
			while(rs.next()) {
				p.setBiaoti(rs.getString("title"));
				p.setPid(rs.getInt("pid"));
				p.setNeirong(rs.getString("content"));
				p.setYonghu(rs.getString("uname"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}

	
	//回复
	@Override
	public boolean addReply(Reply rep) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		//获取当前时间
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		int a=0;
		try {
			conn=JDBCutil.getConnection();
			String s="insert into t_reply(rcontent,uid,pid,adddate) value(?,?,?,?) ";
			ps=(PreparedStatement) conn.prepareStatement(s);
			ps.setString(1, rep.getRcontent());
			ps.setInt(2, rep.getUid());
			ps.setInt(3, rep.getPid());
			ps.setString(4, date);
			a=ps.executeUpdate();
			if(a==1) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	@Override
	public List huifub( int pid,Page page) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		//System.out.println(pid);
		List list=new ArrayList();
		ResultSet rs=null;
		try {
			conn=JDBCutil.getConnection();
			String s="select * from t_post,t_reply,t_user where t_post.pid=t_reply.pid and t_user.id=t_reply.uid and t_Reply.pid=? limit ?,?";
			ps=(PreparedStatement) conn.prepareStatement(s);
			ps.setInt(1, pid);
			ps.setInt(2, page.getPageNext());
			ps.setInt(3, page.getPageSize());
			
			rs=ps.executeQuery();
			while(rs.next()){
			Reply re=new Reply();
			re.setName2(rs.getString("uname"));
			re.setTitle(rs.getString("title"));
			re.setRid(rs.getInt("rid"));
			re.setPid(rs.getInt("pid"));
			re.setRcontent(rs.getString("rcontent"));
			re.setUid(rs.getInt("uid"));
			re.setDate(rs.getDate("adddate"));
			re.setList(ReplyTo2(rs.getInt("rid")));
			System.out.println(rs.getInt("rid"));
			System.out.println(ReplyTo2(rs.getInt("rid")));
			list.add(re);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//总记录数
	public int getrow() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rows=0;
		try {
			conn=JDBCutil.getConnection();
			String s="select count(*) from t_reply";
			ps=(PreparedStatement) conn.prepareStatement(s);
			rs=ps.executeQuery();
			while(rs.next()) {
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
	

	@Override
	public List last(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUserImg(User u) {
		// TODO Auto-generated method stub
		//连接对象
				Connection conn=null;
				//预编译
				PreparedStatement ps=null;
				//结果集
				ResultSet rs=null;
				//标记
				boolean flag=true;
				try {
					//获取连接
					conn=JDBCutil.getConnection();
					//sql语句
					String s="update t_user u set u.picPath=? where u.id=?";
					//获取预编译
					ps=(PreparedStatement) conn.prepareStatement(s);
					//传参
					ps.setString(1, u.getPicPath());
					ps.setInt(2, u.getId());
					//执行并返回结果
					int num=ps.executeUpdate();
					if(num==1) {
						flag=true;
					}else {
						flag=false;
					}
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						JDBCutil.free(conn, ps, rs);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return flag;
	}

	public boolean ReplyTo(int rid,String data,int uid,int pid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		//预编译
		PreparedStatement ps=null;
		//结果集
		ResultSet rs=null;
		//标记
		boolean flag=true;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adddate=df.format(new Date());
		int tid=rid;
		try {
			conn=JDBCutil.getConnection();
			String s="insert into t_reply(rcontent,uid,tid,pid,adddate) value(?,?,?,?,?)";
			ps=(PreparedStatement) conn.prepareStatement(s);
			ps.setString(1, data);
			ps.setInt(2, uid);
			ps.setInt(3, tid);
			ps.setInt(4, pid);
			ps.setString(5, adddate);
			int num=ps.executeUpdate();
			if(num==1) {
				flag=true;
			}else {
				flag=false;
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
}

	@Override
	public List ReplyTo2(int rid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		//预编译
		PreparedStatement ps=null;
		//结果集
		ResultSet rs=null;
		//System.out.println(rid);
		//标记
		boolean flag=true;
		List list =new ArrayList();
		try {
			conn=JDBCutil.getConnection();
			String s="select * from t_reply,t_user where t_user.id=t_reply.uid and tid=?";
			ps=(PreparedStatement) conn.prepareStatement(s);
			ps.setInt(1, rid);
			rs=ps.executeQuery();
			while(rs.next()) {
				Reply re=new Reply();
				re.setRcontent(rs.getString("rcontent"));
				re.setHmane(rs.getString("uname"));
				re.setDate(rs.getDate("adddate"));
				list.add(re);
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	//总记录数
	public int getrow2(int pid) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rows=0;
		try {
			conn=JDBCutil.getConnection();
			String s="select count(*) from t_reply where pid=?";
			
			ps=(PreparedStatement) conn.prepareStatement(s);
			ps.setInt(1, pid);
			rs=ps.executeQuery();
			while(rs.next()) {
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCutil.free(conn, ps,null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
	

	
	
	
	}
	

	