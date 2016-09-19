from __future__ import print_function
from nltk.metrics import *

def test_metrics():
    training = 'PERSON OTHER PERSON OTHER OTHER ORGANIZATION'.split()
    testing = 'PERSON OTHER OTHER OTHER OTHER OTHER'.split()
    print(accuracy(training,testing))
    trainset=set(training)
    testset=set(testing)
    print(precision(trainset,testset))
    print(recall(trainset,testset))
    print(f_measure(trainset,testset))


def test_jacc_sim():
    x=set([10,20,30,40])
    y=set([20,30,60])
    print(jaccard_distance(x,y))

if __name__ == "__main__":
    test_jacc_sim()
    
