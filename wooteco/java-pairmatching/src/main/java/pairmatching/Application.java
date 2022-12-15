package pairmatching;

import pairmatching.controller.CourseController;

public class Application {
    public static void main(String[] args) {
        CourseController courseController = new CourseController();
        courseController.start();
    }
}
