import nltk
from nltk.util import ngrams
from nltk.corpus import alpino
from nltk.collocations import BigramCollocationFinder
from nltk.corpus import webtext
from nltk.metrics import BigramAssocMeasures

alpino.words()
unigrams=ngrams(alpino.words(),1)
for i in unigrams:
    print i

tokens = [t.lower() for t in webtext.words('grail.txt')]
words = BigramCollocationFinder.from_words(tokens)
print words.nbset(BigramAssocMeasures.likelihood_ratio,10)
