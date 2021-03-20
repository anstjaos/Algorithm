#include <iostream>
using namespace std;

int arr[10001], N;
long long M;
int result;

int main()
{
	cin >> N >> M;
	for (int i = 0; i < N; i++) cin >> arr[i];

	int left=0, right=0;
	long long sum = arr[0];

	while (left <= right && right < N)
	{
		if (sum == M)
		{
			result++;
			right++;
			sum += arr[right];
		}
		else if( sum < M)
		{
			right++;
			sum += arr[right];

		}
		else if (sum > M)
		{
			sum -= arr[left];
			left++;


			if (left > right && left < N)
			{
				right = left;
				sum = arr[left];
			}
		}
	
	}

	cout << result << endl;
	return 0;
}