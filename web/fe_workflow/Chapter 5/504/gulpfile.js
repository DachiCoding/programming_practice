var gulp = require('gulp');
var browserSync = require('browser-sync').create();
var minifyCss = require('gulp-minify-css');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');
var imageMin = require('gulp-imagemin');
var handlebars = require('gulp-compile-handlebars');
var rename = require('gulp-rename');

gulp.task('templates', function(){
  var data = {};

  var options = {
    batch: ['src/templates/partials']
  }

  return gulp.src(['src/templates/**/*.hbs', '!src/templates/partials/**/*.hbs'])
    .pipe(handlebars(data, options))
    .pipe(rename(function (path) {
      path.extname = '.html'
    }))
    .pipe(gulp.dest('./'));
})

gulp.task('images', function() {
  gulp.src(['src/img/**/*'])
    .pipe(imageMin())
    .pipe(gulp.dest('dist/img'))
    .pipe(browserSync.stream());
});

gulp.task('scripts', function(){
  gulp.src(['src/scripts/main.js'])
    .pipe(sourcemaps.init())
    .pipe(uglify())
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('dist/scripts'))
    .pipe(browserSync.stream());
});

gulp.task('styles', function(){
  gulp.src(['src/styles/**/*.css'])
    .pipe(sourcemaps.init())
    .pipe(minifyCss())
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('dist/styles'))
    .pipe(browserSync.stream());
});

gulp.task('default', ['styles', 'images', 'scripts', 'templates'], function(){
  browserSync.init({
    server: './'
  });
  //gulp.watch('src/**/*', browserSync.reload);
  gulp.watch('src/styles/**/*.css', ['styles']);
  gulp.watch('src/img/**/*', ['images']);
  gulp.watch('src/scripts/**/*.js', ['scripts']);
  gulp.watch('src/templates/**/*.hbs', ['templates']);
  gulp.watch('*.html', browserSync.reload);
});
