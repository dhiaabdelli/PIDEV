/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import com.github.plushaze.traynotification.animations.Animations;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import com.github.plushaze.traynotification.models.CustomStage;
import com.github.plushaze.traynotification.notification.Notification;
import com.github.plushaze.traynotification.notification.Notifications;
import com.lynden.gmapsfx.javascript.object.Animation;

import java.io.IOException;
import java.net.URL;
/**
 *
 * @author dorra
 */
public final class TrayNotification {
	@FXML
	private Label lblTitle, lblMessage, lblClose;
	@FXML
	private ImageView imageIcon;
	@FXML
	private Rectangle rectangleColor;
	@FXML
	private AnchorPane rootNode;

	private CustomStage stage;
	private Notification notification;
	private Animation animation;
	private EventHandler<ActionEvent> onDismissedCallBack, onShownCallback;

	/**
	 * Initializes an instance of the tray notification object
	 *
	 * @param title         The title text to assign to the tray
	 * @param body          The body text to assign to the tray
	 * @param img           The image to show on the tray
	 * @param rectangleFill The fill for the rectangle
	 */
	public TrayNotification(String title, String body, Image img,
	                        Paint rectangleFill, Notification notification) {
		initTrayNotification(title, body, notification);

		setImage(img);
		setRectangleFill(rectangleFill);
	}

	/**
	 * Initializes an instance of the tray notification object
	 *
	 * @param title        The title text to assign to the tray
	 * @param body         The body text to assign to the tray
	 * @param notification The notification type to assign to the tray
	 */
	public TrayNotification(String title, String body, Notification notification) {
		initTrayNotification(title, body, notification);
	}

	/**
	 * Initializes an empty instance of the tray notification
	 */
	public TrayNotification(Notification notification) {
		this("", "", notification);
	}

	/**
	 * Initializes the tray notification with the default type.
	 */
	public TrayNotification() {
		this(Notifications.NOTICE);
	}

	private void initTrayNotification(String title, String message, Notification type) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("views/TrayNotification.fxml"));

		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		initStage();
		

		setTray(title, message, type);
	}


	private void initStage() {
		stage = new CustomStage(rootNode, StageStyle.UNDECORATED);
		stage.setScene(new Scene(rootNode));
		stage.setAlwaysOnTop(true);
		stage.setLocation(stage.getBottomRight());

		lblClose.setOnMouseClicked(e -> dismiss());
	}

	public void setNotification(Notification nType) {
		notification = nType;

		URL imageLocation = getClass().getClassLoader().getResource(nType.getURLResource());
		setRectangleFill(Paint.valueOf(nType.getPaintHex()));
		setImage(new Image(imageLocation.toString()));
		setTrayIcon(imageIcon.getImage());
	}

	public Notification getNotification() {
		return notification;
	}

	public void setTray(String title, String message, Notification type) {
		setTitle(title);
		setMessage(message);
		setNotification(type);
	}

	public void setTray(String title, String message, Image img, Paint rectangleFill, Animation animation) {
		setTitle(title);
		setMessage(message);
		setImage(img);
		setRectangleFill(rectangleFill);
		setAnimation(animation);
	}



	/**
	 * Shows and dismisses the tray notification
	 *
	 * @param dismissDelay How long to delay the start of the dismiss animation
	 */


	/**
	 * Displays the notification tray
	 */


	/**
	 * Dismisses the notifcation tray
	 */

	private void onShown() {
		if (onShownCallback != null)
			onShownCallback.handle(new ActionEvent());
	}

	private void onDismissed() {
		if (onDismissedCallBack != null)
			onDismissedCallBack.handle(new ActionEvent());
	}

	/**
	 * Sets an action event for when the tray has been dismissed
	 *
	 * @param event The event to occur when the tray has been dismissed
	 */
	public void setOnDismiss(EventHandler<ActionEvent> event) {
		onDismissedCallBack = event;
	}

	/**
	 * Sets an action event for when the tray has been shown
	 *
	 * @param event The event to occur after the tray has been shown
	 */
	public void setOnShown(EventHandler<ActionEvent> event) {
		onShownCallback = event;
	}

	/**
	 * Sets a new task bar image for the tray
	 *
	 * @param img The image to assign
	 */
	public void setTrayIcon(Image img) {
		stage.getIcons().clear();
		stage.getIcons().add(img);
	}

	public Image getTrayIcon() {
		return stage.getIcons().get(0);
	}

	/**
	 * Sets a title to the tray
	 *
	 * @param txt The text to assign to the tray icon
	 */
	public void setTitle(String txt) {
		Platform.runLater(() -> lblTitle.setText(txt));
	}

	public String getTitle() {
		return lblTitle.getText();
	}

	/**
	 * Sets the message for the tray notification
	 *
	 * @param txt The text to assign to the body of the tray notification
	 */
	public void setMessage(String txt) {
		lblMessage.setText(txt);
	}

	public String getMessage() {
		return lblMessage.getText();
	}

	public void setImage(Image img) {
		imageIcon.setImage(img);

		setTrayIcon(img);
	}

	public Image getImage() {
		return imageIcon.getImage();
	}

	public void setRectangleFill(Paint value) {
		rectangleColor.setFill(value);
	}

	public Paint getRectangleFill() {
		return rectangleColor.getFill();
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}


	public Animation getAnimation() {
		return animation;
	}

    private void dismiss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

