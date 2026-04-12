package org.firstinspires.ftc.teamcode.Mechanisms;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.HeadingInterpolator;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;

public class PedroAutoFollower {
    public static Follower follower;//IMPORTANT CHECK AND REDO INFO FOR ALL POSES
    public static final Pose blue_Short_Start = new Pose(33, 136, Math.toRadians(90));
    public static final Pose red_Short_Start = new Pose(111, 136, Math.toRadians(90));
    public static final Pose blue_Long_Start = new Pose(57, 8, Math.toRadians(90));
    public static final Pose red_Long_Start = new Pose(87, 8, Math.toRadians(90));
    public static final Pose blue_Short_Shoot_1 = new Pose(48, 96, Math.toRadians(170));
    public static final Pose red_Short_Shoot_1 = new Pose(96, 96, Math.toRadians(135));
    public static final Pose blue_Short_Shoot_2 = new Pose(60, 120, Math.toRadians(160));
    public static final Pose red_Short_Shoot_2 = new Pose(84, 120, Math.toRadians(30));
    public static final Pose blue_Long_Shoot = new Pose(63, 25, Math.toRadians(120));
    public static final Pose red_Long_Shoot = new Pose(81, 25, Math.toRadians(60));
    public static final Pose blue_Long_End = new Pose(60, 36, Math.toRadians(0));
    public static final Pose red_Long_End = new Pose(84, 36, Math.toRadians(180));
    public static final Pose blue_Lane_1_start= new Pose(48, 84, Math.toRadians(180));
    public static final Pose blue_Lane_1_pickup= new Pose(15, 84, Math.toRadians(180));
    public static final Pose blue_Lane_2_start= new Pose(48, 60, Math.toRadians(180));
    public static final Pose blue_Lane_2_pickup= new Pose(8, 60, Math.toRadians(180));
    public static final Pose blue_Lane_3_start= new Pose(48, 36, Math.toRadians(180));
    public static final Pose blue_Lane_3_pickup= new Pose(48, 36, Math.toRadians(180));
    public static final Pose red_Lane_1_start= new Pose(96, 84, Math.toRadians(0));
    public static final Pose red_Lane_1_pickup= new Pose(129, 84, Math.toRadians(0));
    public static final Pose red_Lane_2_start= new Pose(96, 60, Math.toRadians(0));
    public static final Pose red_Lane_2_pickup= new Pose(136, 60, Math.toRadians(0));
    public static final Pose red_Lane_3_start= new Pose(96, 35, Math.toRadians(0));
    public static final Pose red_Lane_3_pickup= new Pose(136, 35, Math.toRadians(0));
    public static PathChain go_Blue_Short_Shoot_1;
    public static PathChain go_Red_Short_Shoot_1;
    public static PathChain go_Blue_Short_Shoot_2;
    public static PathChain go_Red_Short_Shoot_2;
    public static PathChain go_Blue_Long_Shoot;
    public static PathChain go_Red_Long_Shoot;
    public static PathChain go_Blue_Long_End;
    public static PathChain go_Red_Long_End;
    public static PathChain go_Blue_Lane_1_Start;
    public static PathChain go_Blue_Lane_1_Pickup;
    public static PathChain go_Blue_Lane_2_Start;
    public static PathChain go_Blue_Lane_2_Pickup;
    public static PathChain go_Blue_Lane_3_Start;
    public static PathChain go_Blue_Lane_3_Pickup;
    public static PathChain go_Red_Lane_1_Start;
    public static PathChain go_Red_Lane_1_Pickup;
    public static PathChain go_Red_Lane_2_Start;
    public static PathChain go_Red_Lane_2_Pickup;
    public static PathChain go_Red_Lane_3_Start;
    public static PathChain go_Red_Lane_3_Pickup;
    public static void buildPaths() {
        go_Blue_Short_Shoot_1 = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Short_Shoot_1)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Short_Shoot_1.getHeading(), 0.8))
                .build();
        go_Red_Short_Shoot_1 = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Short_Shoot_1)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Short_Shoot_1.getHeading(), 0.8))
                .build();
        go_Blue_Short_Shoot_2 = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Short_Shoot_2)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Short_Shoot_2.getHeading(), 0.8))
                .build();
        go_Red_Short_Shoot_2 = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Short_Shoot_2)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Short_Shoot_2.getHeading(), 0.8))
                .build();
        go_Blue_Long_Shoot = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Long_Shoot)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Long_Shoot.getHeading(), 0.8))
                .build();
        go_Red_Long_Shoot = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Long_Shoot)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Long_Shoot.getHeading(), 0.8))
                .build();
        go_Blue_Long_End = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Long_End)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Long_End.getHeading(), 0.8))
                .build();
        go_Red_Long_End = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Long_End)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Long_End.getHeading(), 0.8))
                .build();
        go_Blue_Lane_1_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_1_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_1_start.getHeading(), 0.8))
                .build();
        go_Blue_Lane_1_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_1_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_1_pickup.getHeading(), 0.8))
                .build();
        go_Blue_Lane_2_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_2_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_2_start.getHeading(), 0.8))
                .build();
        go_Blue_Lane_2_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_2_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_2_pickup.getHeading(), 0.8))
                .build();
        go_Blue_Lane_3_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_3_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_3_start.getHeading(), 0.8))
                .build();
        go_Blue_Lane_3_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, blue_Lane_3_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, blue_Lane_3_pickup.getHeading(), 0.8))
                .build();
        go_Red_Lane_1_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_1_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_1_start.getHeading(), 0.8))
                .build();
        go_Red_Lane_1_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_1_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_1_pickup.getHeading(), 0.8))
                .build();
        go_Red_Lane_2_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_2_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_2_start.getHeading(), 0.8))
                .build();
        go_Red_Lane_2_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_2_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_2_pickup.getHeading(), 0.8))
                .build();
        go_Red_Lane_3_Start = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_3_start)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_3_start.getHeading(), 0.8))
                .build();
        go_Red_Lane_3_Pickup = follower.pathBuilder()
                .addPath(new Path(new BezierLine(follower::getPose, red_Lane_3_pickup)))
                .setHeadingInterpolation(HeadingInterpolator.linearFromPoint(follower::getHeading, red_Lane_3_pickup.getHeading(), 0.8))
                .build();
    }
}
