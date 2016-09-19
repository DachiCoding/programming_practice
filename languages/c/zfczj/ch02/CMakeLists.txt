cmake_minimum_required(VERSION 3.3)
project(ch02)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    alignment.c
    auto.c
    book_data.c
    free.c
    intToStr.c
    malloc_test.c
    print_address.c
    quick_sort.c
    tiny_printf.c
    vmtest.c)

add_executable(ch02 ${SOURCE_FILES})