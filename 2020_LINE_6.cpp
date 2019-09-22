#include <iostream>
#include <string>
using namespace std;

typedef struct {
	int size;
	string num;
}Data;

int N, maxSize;
string print;
Data dataArr[200];

int max(int a, int b) { return (a > b ? a : b); }

void printDot(int width)
{
	for (register int i = 0; i < width; i++) cout << ".";
	cout << " ";
}

void printLine(int width, int idx, int num)
{
	switch (num)
	{
	case 0:
		if (idx == 0 || idx == width * 2 - 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else {
			cout << "#";
			for (register int i = 1; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 1:
		for (register int i = 0; i < width - 1; i++) cout << ".";
		cout << "#";
		break;
	case 2:
		if (idx == 0 || idx == width * 2 - 2 || idx == (width*2-1) /2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else if(idx < (width * 2 - 1) /2) {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		else {
			cout << "#";
			for (register int i = 0; i < width - 1; i++) cout << ".";
		}
		break;
	case 3:
		if (idx == 0 || idx == width * 2 - 2 || idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 4:
		if (idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else if (idx < (width * 2 - 1) / 2) {
			cout << "#";
			for (register int i = 1; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		else {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 5:
		if (idx == 0 || idx == width * 2 - 2 || idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else if (idx < (width * 2 - 1) / 2) {
			cout << "#";
			for (register int i = 0; i < width - 1; i++) cout << ".";
		}
		else {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 6:
		if (idx == width * 2 - 2 || idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else if (idx < (width * 2 - 1) / 2) {
			cout << "#";
			for (register int i = 0; i < width - 1; i++) cout << ".";
		}
		else {
			cout << "#";
			for (register int i = 1; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 7:
		if (idx == 0) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 8:
		if (idx == 0 || idx == width * 2 - 2 || idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else {
			cout << "#";
			for (register int i = 1; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	case 9:
		if (idx == 0 || idx == (width * 2 - 1) / 2) {
			for (register int i = 0; i < width; i++) cout << "#";
		}
		else if (idx < (width * 2 - 1) / 2) {
			cout << "#";
			for (register int i = 1; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		else {
			for (register int i = 0; i < width - 1; i++) cout << ".";
			cout << "#";
		}
		break;
	default:
		break;
	}
	cout << " ";
}

void printTop()
{
	for (register int s = 0; s < maxSize * 2 - 1; s++) {
		
		for (register int i = 0; i < N; i++) {
			if (dataArr[i].size == maxSize) {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					printLine(maxSize, s, dataArr[i].num[j] - '0');
				}
			}
			else {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					int width = dataArr[i].size;
					if (s >= width * 2 - 1) printDot(width);
					else printLine(width, s, dataArr[i].num[j] - '0');
				}
				
			}
		}

		cout << "\n";
	}
}

void printMiddle()
{
	for (register int s = 0; s < maxSize * 2 - 1; s++) {

		for (register int i = 0; i < N; i++) {
			if (dataArr[i].size == maxSize) {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					printLine(maxSize, s, dataArr[i].num[j] - '0');
				}
			}
			else {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					int width = dataArr[i].size;

					if (s < maxSize - width || s >= maxSize + width - 1) printDot(width);
					else printLine(width, s - (maxSize - width), dataArr[i].num[j] - '0');
				}
			}
		}

		cout << "\n";
	}
}

void printBottom()
{
	for (register int s = 0; s < maxSize * 2 - 1; s++) {

		for (register int i = 0; i < N; i++) {
			if (dataArr[i].size == maxSize) {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					printLine(maxSize, s, dataArr[i].num[j] - '0');
				}
			}
			else {
				int size = dataArr[i].num.size();
				for (register int j = 0; j < size; j++) {
					int width = dataArr[i].size;
					if (s < (maxSize- width)*2) printDot(width);
					else printLine(width, s - (maxSize - width) * 2, dataArr[i].num[j] - '0');
				}
			}
		}

		cout << "\n";
	}
}

int main()
{
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);

	cin >> N >> print;
	for (register int i = 0; i < N; i++) {
		cin >> dataArr[i].size >> dataArr[i].num;
		maxSize = max(maxSize, dataArr[i].size);
	}

	if (print[0] == 'T') printTop();
	else if (print[0] == 'M') printMiddle();
	else if (print[0] == 'B') printBottom();

	return 0;
}