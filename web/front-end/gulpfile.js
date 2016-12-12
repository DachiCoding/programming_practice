//Importing modules
var gulp = require('gulp');
var browserSync = require('browser-sync').create();
var minifyCss = require('gulp-minify-css');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');
var imageMin = require('gulp-imagemin');
var handlebars = require('gulp-compile-handlebars');
var rename = require('gulp-rename');
var less = require('gulp-less');
var autoprefixer = require('gulp-autoprefixer');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var jshint = require('gulp-jshint');
var mocha = require('gulp-mocha');
var a11y = require('gulp-a11y');

//Markup & template tasks
gulp.task('templates',function(){
    var data = {};
    var options = {
        batch: ['src/templates/partials']
    };

    return gulp.src(['src/templates/**/*.hbs','!src/templates/partials/**/*.hbs'])
        .pipe(handlebars(data,options))
        .pipe(rename(function(path){
            path.extname = '.html'
        }))
        .pipe(gulp.dest('./'));
});

//Image process
gulp.task('images',function(){
    gulp.src(['src/img/**/*'])
    .pipe(imageMin())
    .pipe(gulp.dest('dist/img'))
    .pipe(browserSync.stream());
});

//Style tasks
gulp.task('styles',function(){
    gulp.src(['src/styles/main.less'])
        .pipe(sourcemaps.init())
        .pipe(less())
        .pipe(autoprefixer())
        .pipe(minifyCss())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('dist/styles'))
        .pipe(browserSync.stream())
});

//Script tasks
gulp.task('scripts',function(){
    var b = browserify({
        entries: 'src/scripts/main.js',
        debug: true
    });

    b.bundle()
        .pipe(source('main.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps:true}))
        .pipe(uglify())
        .pipe(sourcemaps.write('./'))
        .pipe(gulp.dest('dist/scripts/'))
        .pipe(browserSync.stream())
});

//Testing tasks
gulp.task('unit-test',function(){
    gulp.src('test/*.js')
        .pipe(mocha())
});

//Linting tasks
gulp.task('lint',function(){
    gulp.src('src/scripts/**/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

//Collection of test tasks
gulp.task('test',['unit-test','lint']);

//Default task
gulp.task('default',['templates','styles','scripts','images','test'],function(){
    browserSync.init({
        server: './'
    });

    gulp.watch('src/styles/**/*.less', ['styles']);
    gulp.watch('src/img/**/*',['images']);
    gulp.watch('src/scripts/**/*.js', ['scripts']);
    gulp.watch('src/templates/**/*.hbs', ['templates']);
    gulp.watch('*.html', browserSync.reload);
});
