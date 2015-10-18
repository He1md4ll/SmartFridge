var gulp = require("gulp");
var vulcanize = require("gulp-vulcanize");
var crisper = require("gulp-crisper");

gulp.task("default", function () {

    return gulp.src("www/index.html")
        .pipe(vulcanize({
            abspath: "",
            excludes: [],
            stripExcludes: false,
            inlineScripts: true,
            inlineCss: true
        }))
        .pipe(crisper({
            scriptInHead: true,
            onlySplit: false
        }))
        .pipe(gulp.dest("build"));
});