package datasqltest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketViewController implements Initializable {

    @FXML
    private VBox chosenProfileCard;

    @FXML
    private Label profileNameLabel,profileIdLabel;

    @FXML
    private ImageView profileImage;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;


    private List<Product> profiles = new ArrayList<>();
    private Image image;
    private MyListener myListener;

//    private void showSelectData(ProfileModel profileModel){
//
//    }

    private List<Product> getData(){
        List<Product> profiles = new ArrayList<>();
        Product profile;

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String connectQuery = "SELECT * FROM microchip.product";

        try {

            Statement statement = connectionDB.createStatement();
            ResultSet queryOutPut = statement.executeQuery(connectQuery);
            while (queryOutPut.next()){
                profile = new Product();
                profile.setName_P(queryOutPut.getString("name_P"));
                profile.setId_P(queryOutPut.getString("id_P"));
//                profile.setImage_P(queryOutPut.getString("image_P"));
//                profile.setColor("6A7324");
                profiles.add(profile);
                File brandingFile = new File(queryOutPut.getString("image_P"));
                Image brandingImage = new Image(brandingFile.toURI().toString());
//                imageView.setImage(brandingImage);
                profile.setImage_P(brandingImage.getUrl());
            }
        } catch (Exception e){
            e.printStackTrace();
        }



//        profile = new Product();
//        profile.setName("Gygee");
//        profile.setId(1);
//        profile.setImgSrc("/image/Gygee.jpg");
//        profile.setColor("6A7324");
//        profiles.add(profile);

//        profile = new ProfileModel(0,"","","");
//        profile.setName("Music");
//        profile.setId(2);
//        profile.setImgSrc("/image/Music.jpg");
//        profile.setColor("6A7324");
//        profiles.add(profile);
//
//        profile = new ProfileModel(0,"","","");
//        profile.setName("Mewnich");
//        profile.setId(3);
//        profile.setImgSrc("/image/Mewnich.jpg");
//        profile.setColor("6A7324");
//        profiles.add(profile);


        return profiles;
    }

    private void setChosenProfile(Product profileModel){
        profileNameLabel.setText(profileModel.getName_P());
        profileIdLabel.setText(HelloApplication.CURRENCY + profileModel.getId_P());
        image = new Image(getClass().getResourceAsStream(profileModel.getImage_P()));
        profileImage.setImage(image);
//        chosenProfileCard.setStyle("-fx-background-color: #"+ profileModel.getColor() + ";\n" +
//                "   -fx-background-radius: 30;");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profiles.addAll(getData());
        if (profiles.size() > 0){
            setChosenProfile(profiles.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Product profileModel) {
                    setChosenProfile(profileModel);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < profiles.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/datasqltest/item-view.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(profiles.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane,column++, row);
                //set width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane,new Insets(10));

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
