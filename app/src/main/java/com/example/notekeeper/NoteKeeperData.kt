package com.example.notekeeper

//class declaration with a method that has a return value
class CourseInfo (val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

//class declaration without a method
class NoteInfo (var course: CourseInfo, var title: String, var text: String)