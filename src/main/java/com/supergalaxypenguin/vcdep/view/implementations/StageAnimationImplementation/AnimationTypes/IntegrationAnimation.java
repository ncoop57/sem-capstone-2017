/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supergalaxypenguin.vcdep.view.implementations.stageanimationimplementation.animationtypes;

import com.supergalaxypenguin.vcdep.view.implementations.stageanimationimplementation.StageAnimation;
import com.supergalaxypenguin.vcdep.domain.StageInfo;
import java.util.HashMap;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Howtoon
 */
public class IntegrationAnimation extends StageAnimation{
    TranslateTransition arrow1 = new TranslateTransition();
    TranslateTransition arrow2 = new TranslateTransition();
    
    public IntegrationAnimation(StageInfo info, HashMap<String, ImageView> animationIcons, Rectangle backGround) {
        super(info, backGround);
        
        ImageView[] _images = {animationIcons.get("IntegrationImage1"), 
            animationIcons.get("IntegrationImage2"), 
            animationIcons.get("IntegrationImagePassed"), 
            animationIcons.get("IntegrationImageFailed"),
            animationIcons.get("IntegrationArrow1"),
            animationIcons.get("IntegrationArrow2")
        };
        super.images = _images;
        super.passImage = animationIcons.get("IntegrationImagePassed");
        super.failImage = animationIcons.get("IntegrationImageFailed");
        super.moveToStart();
    }

    @Override
    public void play() {
        System.out.println("Play Integration animation");
        
        arrow1.setNode(super.images[4]);
        arrow1.setToX(84);
        arrow1.setDuration(Duration.seconds(1));
        arrow1.cycleCountProperty().setValue(3);
        arrow1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arrow1.setToX(0);
                arrow1.setDuration(Duration.seconds(0.0001));
                arrow1.play();
                event.consume();
            }
        });
        arrow1.play();
        
        arrow2.setNode(super.images[5]);
        arrow2.setToX(-84);
        arrow2.setDuration(Duration.seconds(1));
        arrow2.cycleCountProperty().setValue(3);
        arrow2.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arrow2.setToX(0);
                arrow2.setDuration(Duration.seconds(0.0001));
                arrow2.play();
                event.consume();
            }
        });
        arrow2.play();
    }

    @Override
    public void stop() {
        System.out.println("Stop Integration animation");
        
        this.arrow1.stop();
        TranslateTransition arrow1;
        arrow1 = new TranslateTransition();
        arrow1.setNode(super.images[4]);
        arrow1.setToX(0);
        arrow1.setDuration(Duration.seconds(0.0001));
        arrow1.play();
        
        this.arrow2.stop();
        TranslateTransition arrow2;
        arrow2 = new TranslateTransition();
        arrow2.setNode(super.images[5]);
        arrow2.setToX(0);
        arrow2.setDuration(Duration.seconds(0.0001));
        arrow2.play();
    }
}
