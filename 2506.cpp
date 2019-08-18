#include <iostream>
using namespace std;

int testCase;
int arr[101];
int result = 0;
int score = 1;
int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> arr[i];
		if (i == 0 && arr[i] == 1)
		{
			result = result + score;
		}
		else if (arr[i] == 1)
		{
			if (arr[i - 1] == 0)
			{
				result = result + score;
				score = 1;
			}
			else
			{
				score++;
				result = result + score;
			}
		}
		else score = 1;
	}
	cout << result << endl;
	
}