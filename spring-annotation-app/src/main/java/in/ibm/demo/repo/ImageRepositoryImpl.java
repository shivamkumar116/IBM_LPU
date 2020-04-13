package in.ibm.demo.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ibm.demo.bean.Image;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

	@Autowired
	private DataSource dataSource;

	/*
	 * public ImageRepositoryImpl(DataSource dataSource) { super(); this.dataSource
	 * = dataSource; }
	 */

	private Connection connection = null;

	private static Logger logger = Logger.getLogger("ImageRepositoryImpl");

	@Override
	public Image createImage(Image image) {

		try {
			logger.log(Level.INFO, "conection to database..........");
			connection = dataSource.getConnection();
			logger.log(Level.INFO, "database connected! Executing statement......");
			PreparedStatement pStatement = connection.prepareStatement("INSERT INTO image values (?,?)");
			pStatement.setString(1, image.getImageID());
			pStatement.setString(2, image.getImageUrl());
			pStatement.executeUpdate();
			logger.log(Level.INFO, "Image created.......");
		} catch (SQLException e) {

			logger.log(Level.SEVERE, "Error connection to database");
			e.printStackTrace();
		}

		return image;
	}

	@Override
	public List<Image> listAll() {
		List<Image> imageList = new ArrayList<Image>();
		try {
			logger.log(Level.INFO, "conection to database..........");
			connection = dataSource.getConnection();
			logger.log(Level.INFO, "database connected! Executing statement......");
			PreparedStatement pStatement = connection.prepareStatement("Select * from image");
			ResultSet rs = pStatement.executeQuery();

			while (rs.next()) {

				imageList.add(new Image(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return imageList;
	}

}
