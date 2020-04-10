package in.ibm.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ibm.demo.factory.ConnectionFactory;
import in.ibm.demo.model.Image;

public class ImageCrudDaoImpl implements ImageCrudDao {

	private ConnectionFactory factory = ConnectionFactory.getConnectionObject();
	private Connection con = null;

	@Override
	public void insertImage(Image objImage) {
		try {
			con = factory.getMyConnection();
			PreparedStatement stInsert = con.prepareStatement("INSERT INTO image values(?,?,?)");
			stInsert.clearParameters();
			stInsert.setString(1, objImage.getImageID());
			stInsert.setString(2, objImage.getImageUrl());
			stInsert.setBoolean(3, objImage.isAvailable());
			stInsert.executeUpdate();
			System.out.println("Image inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Image> imageList() {
		try {
			con = factory.getMyConnection();
			PreparedStatement stSelectAll = con.prepareStatement("SELECT * FROM image");
			ResultSet rs = stSelectAll.executeQuery();
			List<Image> images = new ArrayList<Image>();
			while (rs.next()) {
				images.add(new Image(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
			}
			return images;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void deleteImage(String id) {
		try {
			con=factory.getMyConnection();
			PreparedStatement stDelete=con.prepareStatement("DELETE FROM image WHERE imageID=?");
			stDelete.setString(1, id);
			stDelete.executeUpdate();
			System.out.println("Deleted Successfully.......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateImage(Image objImage) {
		try {
			con=factory.getMyConnection();
			PreparedStatement stUpdateImage =con.prepareStatement("UPDATE image SET imageUrl=?,isAvailable=? where imageID=? ");
			stUpdateImage.setString(1, objImage.getImageUrl());
			stUpdateImage.setBoolean(2, objImage.isAvailable());
			stUpdateImage.setString(3, objImage.getImageID());
			stUpdateImage.executeUpdate();
			System.out.println("Image Successfully updated .........");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
