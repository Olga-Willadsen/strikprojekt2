package org.example;

import org.sqlite.core.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeasurementChartDAO {

    private DBConnector dbConnector;

    MeasurementChartDAO (DBConnector dbConnector){this.dbConnector=dbConnector;}


    public void createTable () throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXIST measurement_charts (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name STRING NOT NULL,
                body_width_cm DOUBLE NOT NULL,
                side_seam_cm DOUBLE NOT NULL,
                raglan_height_cm DOUBLE NOT NULL,
                raglan_width_cm DOUBLE NOT NULL,
                neck_width_cm DOUBLE NOT NULL,
                armhole_bindoff_cm DOUBLE NOT NULL)""";

        try (
                Connection conn = dbConnector.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(sql);
        }
    }

    public void insert (MeasurementChart ms)throws SQLException{
        String sql= "INSERT INTO measurement_charts (name, body_width_cm, side_seam_cm, raglan_height_cm, raglan_width_cm, neck_width_cm, armhole_bindoff_cm) VALUES (?,?,?,?,?,?,?)";

        try (
            Connection conn = dbConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, ms.getName());
            ps.setDouble(2, ms.getBodyWidthCM());
            ps.setDouble(3, ms.getSideseamCM());
            ps.setDouble(4, ms.getRaglanHeightCM());
            ps.setDouble(5, ms.getRaglanWidthCM());
            ps.setDouble(6, ms.getNeckWidthCM());
            ps.setDouble(7, ms.getArmholeBindOffCM());

            ps.executeUpdate();

        }



    }

    public List<MeasurementChart> findAll () throws SQLException{
        String sql= "SELECT id, name, body_width_cm, side_seam_cm, raglan_height_cm, raglan_width_cm, neck_width_cm, armhole_bindoff_cm FROM measurement_charts";
        List <MeasurementChart> measurementCharts = new ArrayList<>();

        try(
                Connection conn = dbConnector.getConnection();
                PreparedStatement ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ) { while(rs.next()){
                    measurementCharts.add(new MeasurementChart(rs.getInt("id"), rs.getString("name"),rs.getDouble("body_width_cm"),
                            rs.getDouble("side_seam_cm"), rs.getDouble("raglan_height_cm"), rs.getDouble("raglan_width_cm"),
                            rs.getDouble("neck_width_cm"), rs.getDouble("armhole_bindoff_cm")));

                }
        }
        return measurementCharts;
    }
//
//    public MeasurementChart findById (int id) throws SQLException {
//        String sql = "SELECT ALL FROM measurement_charts WHERE id = ?";
//        MeasurementChart mc;
//
//        try (
//                Connection conn = dbConnector.getConnection();
//                PreparedStatement ps = conn.prepareStatement(sql);
//        ) {}
//
//
//
//
//
//
//
//    }

//create, insert, update, getall, getbyid, delete




}
