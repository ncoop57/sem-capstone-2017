/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supergalaxypenguin.vcdep.view.implementations;



import com.supergalaxypenguin.vcdep.controller.interfaces.iMainController;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Howtoon
 */
public class PipelineSceneController implements Initializable {

    private String status;
    private static PipelineSceneController instance;
    private static iMainController controller;
    private final DropShadow shadow = new DropShadow();
    private final HashMap<String,ImageView> animationIcons = new HashMap<>();
    private String log = "";
    private ArrayList<StageInfo> stageInfo = new ArrayList<>();
    private int numStages;
    private int currentStage;
    private ArrayList<Rectangle> backGrounds = new ArrayList<>();
    private ArrayList<StageAnimation> animations = new ArrayList<>();
    @FXML
    public ImageView chkoutImage1;
    @FXML
    private ImageView chkoutImage2;
    @FXML
    private ImageView chkoutImage3;
    @FXML
    private ImageView chkoutImagePassed;
    @FXML
    private ImageView chkoutImageFailed;
    @FXML
    private ImageView SAImage1;
    @FXML
    private ImageView SAImage2;
    @FXML
    private ImageView SAImage3;
    @FXML
    private ImageView SAImagePassed;
    @FXML
    private ImageView SAImageFailed;
    @FXML
    private ImageView UnitImage1;
    @FXML
    private ImageView UnitImage2;
    @FXML
    private ImageView UnitImage3;
    @FXML
    private ImageView UnitImagePassed;
    @FXML
    private ImageView UnitImageFailed;
    @FXML
    private ImageView IntegrationImage1;
    @FXML
    private ImageView IntegrationImage2;
    @FXML
    private ImageView IntegrationImagePassed;
    @FXML
    private ImageView IntegrationImageFailed;
    @FXML
    private ImageView DeployImage1;
    @FXML
    private ImageView DeployImage2;
    @FXML
    private ImageView DeployImagePassed;
    @FXML
    private ImageView DeployImageFailed;
    @FXML
    private ImageView BuildImage1;
    @FXML
    private ImageView BuildImage2;
    @FXML
    private ImageView BuildImagePassed;
    @FXML
    private ImageView BuildImageFailed;
    @FXML
    private Rectangle stage1;
    @FXML
    private Rectangle stage2;
    @FXML
    private Rectangle stage3;
    @FXML
    private Rectangle stage4;
    @FXML
    private Rectangle stage5;
    @FXML
    private Rectangle stage6;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label label;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numStages = 5;
        currentStage = -1;
        this.stageInfo.add(new StageInfo(StageType.CHECKOUT, 0, false));
        this.stageInfo.add(new StageInfo(StageType.DEPLOY, 1, true));
        this.stageInfo.add(new StageInfo(StageType.INTEGRATION, 2, false));
        this.stageInfo.add(new StageInfo(StageType.STATIC, 3, true));
        this.stageInfo.add(new StageInfo(StageType.UNIT, 4, false));
        
        this.backGrounds.add(stage1);
        this.backGrounds.add(stage2);
        this.backGrounds.add(stage3);
        this.backGrounds.add(stage4);
        this.backGrounds.add(stage5);
        this.backGrounds.add(stage6);
        
        for (int i = 0; i<backGrounds.size(); i++)
        {
            backGrounds.get(i).setVisible(false);
        }
        
        this.chkoutImage1.setVisible(false);
        this.chkoutImage2.setVisible(false);
        this.chkoutImage3.setVisible(false);
        this.chkoutImageFailed.setVisible(false);
        this.chkoutImagePassed.setVisible(false);
        this.SAImage1.setVisible(false);
        this.SAImage2.setVisible(false);
        this.SAImage3.setVisible(false);
        this.SAImageFailed.setVisible(false);
        this.SAImagePassed.setVisible(false);
        this.UnitImage1.setVisible(false);
        this.UnitImage2.setVisible(false);
        this.UnitImage3.setVisible(false);
        this.UnitImageFailed.setVisible(false);
        this.UnitImagePassed.setVisible(false);
        this.IntegrationImage1.setVisible(false);
        this.IntegrationImage2.setVisible(false);
        this.IntegrationImageFailed.setVisible(false);
        this.IntegrationImagePassed.setVisible(false);
        this.DeployImage1.setVisible(false);
        this.DeployImage2.setVisible(false);
        this.DeployImageFailed.setVisible(false);
        this.DeployImagePassed.setVisible(false);
        //this.BuildImage1.setVisible(false);
        //this.BuildImage2.setVisible(false);
        this.BuildImageFailed.setVisible(false);
        this.BuildImagePassed.setVisible(false);
        
        this.animationIcons.put("chkoutImage1",this.chkoutImage1);
        this.animationIcons.put("chkoutImage2",this.chkoutImage2);
        this.animationIcons.put("chkoutImage3",this.chkoutImage3);
        this.animationIcons.put("chkoutImageFailed",this.chkoutImageFailed);
        this.animationIcons.put("chkoutImagePassed",this.chkoutImagePassed);
        this.animationIcons.put("SAImage1",this.SAImage1);
        this.animationIcons.put("SAImage2",this.SAImage2);
        this.animationIcons.put("SAImage3",this.SAImage3);
        this.animationIcons.put("SAImageFailed",this.SAImageFailed);
        this.animationIcons.put("SAImagePassed",this.SAImagePassed);
        this.animationIcons.put("UnitImage1",this.UnitImage1);
        this.animationIcons.put("UnitImage2",this.UnitImage2);
        this.animationIcons.put("UnitImage3",this.UnitImage3);
        this.animationIcons.put("UnitImageFailed",this.UnitImageFailed);
        this.animationIcons.put("UnitImagePassed",this.UnitImagePassed);
        this.animationIcons.put("IntegrationImage1",this.IntegrationImage1);
        this.animationIcons.put("IntegrationImage2",this.IntegrationImage2);
        this.animationIcons.put("IntegrationImageFailed",this.IntegrationImageFailed);
        this.animationIcons.put("IntegrationImagePassed",this.IntegrationImagePassed);
        this.animationIcons.put("DeployImage1",this.DeployImage1);
        this.animationIcons.put("DeployImage2",this.DeployImage2);
        this.animationIcons.put("DeployImageFailed",this.DeployImageFailed);
        this.animationIcons.put("DeployImagePassed",this.DeployImagePassed);
        this.animationIcons.put("BuildImage1",this.BuildImage1);
        this.animationIcons.put("BuildImage2",this.BuildImage2);
        this.animationIcons.put("BuildImageFailed",this.BuildImageFailed);
        this.animationIcons.put("BuildImagePassed",this.BuildImagePassed);
    }
        
    @FXML
    private void handleMouseExitedButton(ActionEvent event){
        Button clickedButton = (Button)event.getSource();
        clickedButton.setEffect(null);
    }
    
    @FXML
    private void handleMouseEnteredButton(ActionEvent event){
        Button clickedButton = (Button)event.getSource();
        clickedButton.setEffect(shadow);
    }
    
    public void handleBtnPause(ActionEvent event)
    {
        System.out.println("Test Pause Button");
        
    }
    
    public void handleBtnPlay(ActionEvent event)
    {
        System.out.println("Test Play Button");
        
    }
    
    @FXML
    private void handleBtnGoBack(ActionEvent event)
    {
        System.out.println("Test Go Back Button");
        this.getLastAnimation();
    }
    
    @FXML
    private void handleBtnForward(ActionEvent event)
    {
        System.out.println("Test Forward Button");
        this.getNextAnimation();
    }
    
    @FXML
    private void handleBtnReset(ActionEvent event)
    {
        System.out.println("Test Reset Button");
    }
    
    @FXML
    private void handleBtnReSubmit(ActionEvent event)
    {
        System.out.println("Test Re-Submit Button");
    }
    /**
     * Updates the message in the scroll pane window
     * @param message 
     */
    public void updateScrollPane(String message)
    {
        status = message;
        try
        {
            label.setWrapText(true);
            label.setText(message);
            label.setPrefWidth(365);
            scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
            scrollPane.setPrefSize(375, 385);
            scrollPane.setContent(label);
        }
        catch(Exception e)
        {
            
        }
    }
    
    /**
     * Creates the ConfigurationViewController
     */
    public PipelineSceneController()
    {
        instance = this;
    }
    
    /**
     * Creates the PipelineSceneController
     * @return returns instance of PipelineSceneController
     */
    public static PipelineSceneController getInstance()
    {
        if (instance == null)
            instance = new PipelineSceneController();
        return instance;
    }
    
    /**
     * Sets the controller variable to the interface of the MainController,
     * This must be done before the view can be used.
     * @param _controller interface of the MainController
     */
    public void setMainControllerInterface(iMainController _controller)
    {
        PipelineSceneController.controller = _controller;
    }
    
    /**
     * Gets the current status message
     * @return 
     */
    public String getStatusMessage()
    {
        return status;
    }
    private void createNewAnimations(int i)
    {
        animations.add(new StageAnimation(stageInfo.get(i+1), this.animationIcons, backGrounds.get(i+1)));
    }
    private void removeAnimation(int i)
    {
        animations.get(i).moveToEnd();
        animations.remove(i);
    }
    private void getNextAnimation()
    {
        if (this.currentStage<stageInfo.size()-1)
        {
            createNewAnimations(this.currentStage);
            this.currentStage++;
        }
    }
    private void getLastAnimation()
    {
        if (this.currentStage>-1)
        {
            removeAnimation(this.currentStage);
            this.currentStage--;
        }
    }


/**
 * This Class contains all the necessary information to create
 * a modular animation and control it throughout it's life-cycle.
 * @author Howtoon
 */
    class StageAnimation{
        private StageType type;         //What kind of Stage is it? Only one of each type is allowed
        private int orderNumber;            //what number in the list of stages EG. 1st? 2nd? Starts at 0
        private boolean passed;         //did this stage fail?
        private static final int OFFSET = 85;       //Space between middle of other stage backgrounds
        //private static final int ORIGIN = 137;      
        private Rectangle backGround;                       //The background Area
//        private static final int stdHeight = 54;
//        private static final int stdWidth = 48;
//        private static final int wideWidth = 104;
//        private static final int firstColumnX = 520;
//        private static final int secondColumnX = 654;
//        private static final int thirdColumnX = 791;
//        private static final int passFailColumnX = 868;
//        private static final int integrationMiddleColumnX = 680;
//        private static final int deployMiddleColumnX = 707;
        private ImageView[] images;                             //necessary Animations

        /**
         * Creates a Stage Animation
         * @param info StageInfo class containing stage information
         * @param animationIcons    All animation images
         * @param backGround    The background that corresponds to this stage animation
         */
        public StageAnimation(StageInfo info, HashMap<String,ImageView> animationIcons, Rectangle backGround)
        {
            this.orderNumber = info.getOrderNumber();
            this.passed = info.isPassed();
            this.type = info.getType();
            this.backGround = backGround;
            //this.animationIcons = animationIcons;

            if (null != this.type)
            switch (this.type) {
                case BUILD:
                    this.BuildAnimation(animationIcons);
                    break;
                case CHECKOUT:
                    this.CheckoutAnimation(animationIcons);
                    break;
                case DEPLOY:
                    this.DeployAnimation(animationIcons);
                    break;
                case INTEGRATION:
                    this.IntegrationAnimation(animationIcons);
                    break;
                case STATIC:
                    this.StaticAnimation(animationIcons);
                    break;
                case UNIT:
                    this.UnitAnimation(animationIcons);
                    break;
                default:
                    break;
            }
        }

        /**
         * Gathers images for the Build Animation
         * @param animationIcons All animation icons
         */
        private void BuildAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("BuildImage1"), 
                animationIcons.get("BuildImage1"), 
                animationIcons.get("BuildImage1"), 
                animationIcons.get("BuildImage1"), 
                animationIcons.get("BuildImage1")
            };
            this.images = images;
            this.moveToStart(images);
        }

        /**
         * Gathers images for the Checkout Animation
         * @param animationIcons All animation icons
         */
        private void CheckoutAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("chkoutImage1"), 
                animationIcons.get("chkoutImage2"), 
                animationIcons.get("chkoutImage3"), 
                animationIcons.get("chkoutImagePassed"), 
                animationIcons.get("chkoutImageFailed")
            };
            this.images = images;
            this.moveToStart(images);
        }

        /**
         * Gathers images for the Deployment Animation
         * @param animationIcons All animation icons
         */
        private void DeployAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("DeployImage1"), 
                animationIcons.get("DeployImage2"), 
                animationIcons.get("DeployImagePassed"), 
                animationIcons.get("DeployImageFailed")
            };
            this.images = images;
            this.moveToStart(images);
        }

        /**
         * Gathers images for the Integration Test Animation
         * @param animationIcons All animation icons
         */
        private void IntegrationAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("IntegrationImage1"), 
                animationIcons.get("IntegrationImage2"), 
                animationIcons.get("IntegrationImagePassed"), 
                animationIcons.get("IntegrationImageFailed")
            };
            this.images = images;
            this.moveToStart(images);
        }

        /**
         * Gathers images for the StaticAnalysis Animation
         * @param animationIcons All animation icons
         */
        private void StaticAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("SAImage1"), 
                animationIcons.get("SAImage2"), 
                animationIcons.get("SAImage3"), 
                animationIcons.get("SAImagePassed"), 
                animationIcons.get("SAImageFailed")
            };
            this.images = images;
            this.moveToStart(images);
        }
        /**
         * Gathers images for the UnitTest Animation
         * @param animationIcons All animation icons
         */
        private void UnitAnimation(HashMap<String,ImageView> animationIcons)
        {
            ImageView[] images = {animationIcons.get("UnitImage1"), 
                animationIcons.get("UnitImage2"), 
                animationIcons.get("UnitImage3"), 
                animationIcons.get("UnitImagePassed"), 
                animationIcons.get("UnitImageFailed")
            };
            this.images = images;
            this.moveToStart(images);
        }
        /**
         * Move Icons to the proper stage position
         * @param images All images necessary for the animation;
         */
        private void moveToStart(ImageView[] images)
        {
            TranslateTransition moveToStart;
            this.backGround.setVisible(true);
            for (ImageView i : images)
            {
                moveToStart = new TranslateTransition();
                moveToStart.setNode(i);
                moveToStart.setToY(this.orderNumber*OFFSET);
                moveToStart.setDuration(Duration.seconds(0.0001));
                if ( 
                        i == animationIcons.get("UnitImagePassed") ||
                        i == animationIcons.get("SAImagePassed") ||
                        i == animationIcons.get("DeployImagePassed") ||
                        i == animationIcons.get("IntegrationImagePassed") ||
                        i == animationIcons.get("chkoutImagePassed")
                        )
                {
                    i.setVisible(passed);
                }
                else if (
                        i == animationIcons.get("UnitImageFailed") ||
                        i == animationIcons.get("SAImageFailed") ||
                        i == animationIcons.get("DeployImageFailed") ||
                        i == animationIcons.get("IntegrationImageFailed") ||
                        i == animationIcons.get("chkoutImageFailed")
                        )
                {
                    i.setVisible(!passed);
                }
                else{
                    i.setVisible(true);
                }
                moveToStart.play();
            }
        }
        /**
         * Move Icons back to their original positions
         */
        private void moveToEnd()
        {
            TranslateTransition moveToEnd;
            this.backGround.setVisible(false);
            for (ImageView i : images){
                moveToEnd = new TranslateTransition();
                moveToEnd.setNode(i);
                moveToEnd.setAutoReverse(true);
                moveToEnd.setToY(0);
                moveToEnd.setDuration(Duration.seconds(0.00001));
                moveToEnd.play();
                i.setVisible(false);
            }
        }
    }
}
    
