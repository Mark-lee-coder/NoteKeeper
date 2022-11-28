package com.example.notekeeper

class DataManager {
    val courses = HashMap<String, CourseInfo>() //maps string instances of CourseInfo and assigns them to courses property
    val notes = ArrayList<NoteInfo>() //an arraylist that holds NoteInfo references and assigns them to notes property

    /**this is an initializer block*/
    init {
        initializeCourses()//calls the initializeCourses function
    }

    private fun initializeCourses() {
        var course = CourseInfo("Android_Intents", "Android Programming with Intents") //creates a new course instance
        courses[course.courseId] = course //adds the new course(var course) to our courses collection

        course = CourseInfo("Android_Async", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "Java_Lang")
        courses[course.courseId] = course

        course = CourseInfo(courseId = "Java_Core", title = "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
    }
}