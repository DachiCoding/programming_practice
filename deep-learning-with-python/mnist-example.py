# import stufss
from keras import models
from keras import layers
from keras.datasets import mnist

# building networks
network = models.Sequential()
network.add(layers.Dense(512,activation='relu',input_shape=(28*28,)))
network.add(layers.Dense(10, activation='softmax'))

# destruct the data
(train_images, train_labels),(test_images, test_labels) = mnist.load_data()
