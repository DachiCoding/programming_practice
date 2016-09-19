import re
import nltk
import string
import tn

def removePunc(text):
    no_punc = []
    tokens = tn.wordTokenizer(text)
    x = re.compile('[%s]' % re.escape(string.punctuation))
    for token in tokens:
        new_token = x.sub(u'',token)
        if not new_token == u'':
            no_punc.append(new_token)
    return no_punc

def removeStop(text,stop):
    return [word for word in text if word.lower() not in stop]

def calcStop(text,stop):
    no_punc = removeStop(text,stop)
    return len(no_punc)*1.0/len(text)

if __name__ == "__main__":
    # Test removePunc
    docs = [" It is a pleasant evening.","Guests, who came from US arrived at the venue","Food was tasty."]
    for doc in docs:
        print removePunc(doc)

    # Test removeStop
    from nltk.corpus import stopwords
    stops =set(stopwords.words('english'))
    words =["Don't", 'hesitate','to','ask','question']
    print removeStop(words,stops)

    # Test calcStop
    print calcStop(docs[1],stops)
