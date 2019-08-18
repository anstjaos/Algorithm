#include <iostream>
using namespace std;

char pattern[1000001];
char text[1000001];
int pi[1000001];
int patternLen = 0;
int textLen = 0;

int result[1000001], resultSize, cnt[26];

int strLen(char *str)
{
	int index = 0;
	while (str[index] != '\0') index++;

	return index;
}

void getPi()
{
	int j = 0;
	for (int i = 1; i < patternLen; i++)
	{
		while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

		if (pattern[i] == pattern[j]) pi[i] = ++j;
	}
}

int main()
{
	cin.getline(text, 1000001);
	cin.getline(pattern, 1000001);

	textLen = strLen(text);
	patternLen = strLen(pattern);

	resultSize = 0;

	getPi();

	bool flag = false;
	int j = 0;
	for (int i = 0; i < textLen; i++)
	{
		while (j > 0 && pattern[j] != text[i]) j = pi[j - 1];

		if (text[i] == pattern[j])
		{
			if (j == patternLen - 1)
			{
				result[resultSize++] = i - patternLen + 2;
				j = pi[j];
			}
			else j++;
		}

	}

	printf("%d\n", resultSize);
	for (int i = 0; i < resultSize; i++) printf("%d\n", result[i]);
	return 0;
}