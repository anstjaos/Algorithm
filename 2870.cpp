#include <cstdio>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
#define MAX_SIZE 100005
string arr[MAX_SIZE];
int arrCnt;

bool cmp(const string &a, const string &b) {
	if (a.size() != b.size()) return a.size() < b.size();
	return a < b;
}

int main()
{
	int n;
	scanf("%d", &n);
	for (register int i = 0; i < n; i++) {
		char input[105];
		scanf("%s", input);
		int idx = 0;
		string num = "";
		while (input[idx] != '\0') {
			if ('0' <= input[idx] && input[idx] <= '9') {
				if (input[idx] == '0') {
					if (num != "0") num += (input[idx]);
				}
				else {
					if (num == "0") num = input[idx];
					else num += input[idx];
				}
			}
			else {
				if (num != "")
				{
					arr[arrCnt++] = num;
					num = "";
				}
			}
			idx++;
		}
		if (num != "") arr[arrCnt++] = num;
	}

	sort(arr, arr + arrCnt, cmp);
	for (register int i = 0; i < arrCnt; i++) cout << arr[i] << "\n";
	return 0;
}