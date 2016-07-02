import nltk
from replacers import RegexpReplacer, RepeatReplacer

# Test regexp replacer
replacer = RegexpReplacer()
print replacer.replace("Don't hesitate to ask questions")

# Test repeat replacer
replacer = RepeatReplacer()
print replacer.replace('lotttt')
print replacer.replace('happy')

