package com.example.notekeeper

//class declaration with a method that has a return value
data class CourseInfo (val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

//class declaration without a method
data class NoteInfo(var course: CourseInfo, var title: String, var text: String)