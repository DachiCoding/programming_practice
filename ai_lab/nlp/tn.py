import nltk
import cProfile

#
def sentTokenizer(text):
    from nltk.tokenize import sent_tokenize
    return sent_tokenize(text)

# Use PunktSentenceTokenizer
def punktSentTokenizer(text):
    tokenizer=nltk.data.load('tokenizers/punkt/english.pickle')
    tokens = tokenizer.tokenize(text)
    return tokens

# Tokenize sentences into words
def wordTokenizer(text):
    words = nltk.word_tokenize(text)
    return words

# TreebankWordTokenizer:
def treebankWordTokenizer(text):
    from nltk.tokenize import TreebankWordTokenizer
    tokenizer = TreebankWordTokenizer()
    return tokenizer.tokenize(text)

def punktWordTokenizer(text):
    from nltk.tokenize import WordPunctTokenizer
    tokenizer = WordPunctTokenizer()
    return tokenizer.tokenize(text)

def regexpWordTokenizer(patt,text):
    from nltk.tokenize import RegexpTokenizer
    tokenizer = RegexpTokenizer(patt)
    return tokenizer.tokenize(text)

if __name__ == "__main__":
    
    text = " Welcome readers. I hope you find it interesting. Please do reply."
    print sentTokenizer(text)

    text = " Hello everyone. Hope all are fine and doing well. Hope you find the book interesting"
    print punktSentTokenizer(text)

    text = "PierreVinken , 59 years old , will join as a nonexecutive director on Nov. 29."
    print wordTokenizer(text)

    text = "Have a nice day. I hope you find the book interesting"
    print treebankWordTokenizer(text)

    text = "Don't hesitate to ask questions"
    print punktWordTokenizer(text)

    patt = "[\w]+"
    text = "Don't hesitate to ask questions"
    print regexpWordTokenizer(patt,text)
    

