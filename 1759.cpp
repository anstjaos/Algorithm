#include <iostream>
using namespace std;

char alpha[16];
bool visit[26];
int L, C;
char result[16];

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	char pivot = alpha[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (alpha[leftIndex] < pivot) leftIndex++;
		while (alpha[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(alpha[leftIndex], alpha[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

bool isVowel(char input)
{
	if (input == 'a' || input == 'e' || input == 'i'
		|| input == 'o' || input == 'u') return true;

	return false;
}

void solve(int cnt, int vowel, int cons, int pre)
{
	if (cnt == L)
	{
		for (int i = 0; i < L; i++)
		{
			cout << result[i];
		}
		cout << '\n';
		return;
	}

	if (cnt == L - 1 && vowel < 1)
	{
		for (int i = pre+1; i < C; i++)
		{
			if (visit[alpha[i] - 'a'] == false && isVowel(alpha[i]) == true)
			{
				visit[alpha[i] - 'a'] = true;
				result[cnt] = alpha[i];
				solve(cnt + 1, vowel + 1, cons,i);
				visit[alpha[i] - 'a'] = false;
			}
		}
	}
	else if (cnt == L - 2  && cons == 0)
	{
		for (int i = pre+1; i < C; i++)
		{
			if (visit[alpha[i] - 'a'] == false && isVowel(alpha[i]) == false)
			{
				visit[alpha[i] - 'a'] = true;
				result[cnt] = alpha[i];
				solve(cnt + 1, vowel, cons +1,i);
				visit[alpha[i] - 'a'] = false;
			}
		}
	}
	else if (cnt == L - 1 && cons == 1)
	{
		for (int i = pre + 1; i < C; i++)
		{
			if (visit[alpha[i] - 'a'] == false && isVowel(alpha[i]) == false)
			{
				visit[alpha[i] - 'a'] = true;
				result[cnt] = alpha[i];
				solve(cnt + 1, vowel, cons + 1, i);
				visit[alpha[i] - 'a'] = false;
			}
		}
	}
	else 
	{
		for (int i = pre+1; i < C; i++)
		{
			if (visit[alpha[i] - 'a'] == false)
			{
				visit[alpha[i] - 'a'] = true;
				result[cnt] = alpha[i];

				if (isVowel(alpha[i]) == true) solve(cnt + 1, vowel + 1, cons,i);
				else solve(cnt + 1, vowel, cons + 1,i);

				visit[alpha[i] - 'a'] = false;
			}
		}
	}
}

int main()
{
	cin >> L >> C;
	for (int i = 0; i < C; i++) cin >> alpha[i];

	quickSort(0, C - 1);
	solve(0,0,0,-1);
	return 0;
}