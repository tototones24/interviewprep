def main():
	print("hello")

def ispalindrome(word):
	for x in range(0, len(word)//2):
		if (word[x] != word[len(word) - x - 1]):
			print("false")	
			return
	print("true")

ispalindrome("abbbbea")