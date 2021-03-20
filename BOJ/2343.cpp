#include <iostream>
using namespace std;

int N, M, sum, lesson[100001], temp, low;

int main()
{
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> lesson[i];
		sum += lesson[i];
		if (lesson[i] > low) low = lesson[i];
	}

	int right = sum+1;
	int middle = 0;
	while (low <= right) {
		middle = (low + right) / 2;
		int blueray = 0;
		temp = 0;

		for (int i = 0; i < N; i++) {
			if (temp + lesson[i] > middle) {
				temp = 0;
				blueray++;
			}

			temp += lesson[i];
		}

		if (temp != 0) blueray++;
	
		if (blueray <= M) right = middle-1;
		else low = middle + 1;
	}

	cout << low << "\n";
	return 0;
}