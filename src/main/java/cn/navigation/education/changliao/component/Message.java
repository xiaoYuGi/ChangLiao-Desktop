package cn.navigation.education.changliao.component;

import cn.navigation.education.changliao.enums.MessageSource;
import cn.navigation.education.changliao.tool.AssetLoader;
import cn.navigation.education.changliao.enums.MessageType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Message {
    //消息
    private final Object msg;
    private MessageType type;
    private HBox box;

    public Message(Object msg, MessageType type, MessageSource source) {
        this.msg = msg;
        this.type = type;
        if (type == MessageType.TEXT) {
            initView(source);
        }
    }

    public void initView(MessageSource source) {
        box = new HBox();
        var image = AssetLoader.loadAssetImage("images/header.jpg", 50, 50);
        var header = new ImageView(image);
        var circle = new Circle();
        circle.setCenterX(image.getWidth() / 2);
        circle.setCenterY(image.getHeight() / 2);
        circle.setRadius(25);
        header.setClip(circle);
        var text = new Text(msg.toString());
        text.setFont(Font.font(17f));
        box.setSpacing(10);

        //发起方
        if (source == MessageSource.FRIEND) {
            box.setAlignment(Pos.CENTER_LEFT);
            box.getChildren().addAll(header, text);
        } else {
            box.setAlignment(Pos.CENTER_RIGHT);
            //镜像显示文字
            text.setTranslateX(-1.0f);
            //接收方
            box.getChildren().addAll(text, header);
        }
//        text.setStyle("-fx-border-color: green;-fx-border-width: 1px;-fx-border-insets: " +
//                "10px;-fx-border-radius: 10px;-fx-padding: 5px;-fx-background-color: red");

       // text.wrappingWidthProperty().bind(box.widthProperty().multiply(0.5));

    }

    public HBox getPane() {
        return box;
    }
}
