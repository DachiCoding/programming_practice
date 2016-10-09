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

var menu = require('./menu.json');

gulp.task('templates', function(){
  var data = {
    year: new Date().getFullYear(),
    menu: menu.menuItems
  };

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
  var b = browserify({
    entries: 'src/scripts/main.js',
    debug: true
  });

  b.bundle()
    .pipe(source('main.js'))
    .pipe(buffer())
    .pipe(sourcemaps.init({loadMaps: true}))
    .pipe(uglify())
    .pipe(sourcemaps.write('./'))
    .pipe(gulp.dest('dist/scripts/'))
    .pipe(browserSync.stream());
});

gulp.task('styles', function(){
  gulp.src(['src/styles/main.less'])
    .pipe(sourcemaps.init())
    .pipe(less())
    .pipe(autoprefixer())
    .pipe(minifyCss())
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('dist/styles'))
    .pipe(browserSync.stream());
});

gulp.task('lint', function(){
  gulp.src('src/scripts/**/*.js')
  .pipe(jshint())
  .pipe(jshint.reporter('default'));
});

gulp.task('test', function(){
  gulp.src('test/*.js')
    .pipe(mocha())
});

gulp.task('access', function(){
  gulp.src('index.html')
    .pipe(a11y())
    .pipe(a11y.reporter());
})

gulp.task('default', ['styles', 'images', 'scripts', 'templates'], function(){
  browserSync.init({
    server: './'
  });
  //gulp.watch('src/**/*', browserSync.reload);
  gulp.watch('src/styles/**/*.less', ['styles']);
  gulp.watch('src/img/**/*', ['images']);
  gulp.watch('src/scripts/**/*.js', ['scripts']);
  gulp.watch('src/templates/**/*.hbs', ['templates']);
  gulp.watch('*.html', browserSync.reload);
});
