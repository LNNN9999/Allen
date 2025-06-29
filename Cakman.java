# Dataset Makanan Lengkap untuk Sistem Rekomendasi
import pandas as pd
import numpy as np

# Dataset Makanan Indonesia - Nilai per 100g
food_dataset = {
    'nama_makanan': [
        'Nasi Putih', 'Nasi Merah', 'Nasi Uduk', 'Lontong', 'Ketupat',
        'Ayam Goreng', 'Ayam Bakar', 'Ayam Rendang', 'Bebek Goreng', 'Bebek Bakar',
        'Ikan Lele Goreng', 'Ikan Nila Bakar', 'Ikan Bandeng', 'Ikan Tongkol', 'Ikan Teri',
        'Daging Sapi Rendang', 'Daging Sapi Gudeg', 'Daging Kambing Gulai', 'Bakso Sapi', 'Sate Ayam',
        'Tempe Goreng', 'Tempe Bacem', 'Tahu Goreng', 'Tahu Sumedang', 'Oncom Goreng',
        'Telur Dadar', 'Telur Rebus', 'Telur Balado', 'Telur Asin', 'Telur Puyuh',
        'Sayur Asem', 'Sayur Lodeh', 'Gado-gado', 'Pecel', 'Karedok',
        'Kangkung Cah', 'Bayam Bening', 'Capcay', 'Tumis Kacang Panjang', 'Terong Balado',
        'Mie Ayam', 'Mie Bakso', 'Kwetiau Goreng', 'Bihun Goreng', 'Nasi Goreng',
        'Soto Ayam', 'Soto Betawi', 'Rawon', 'Gudeg', 'Opor Ayam',
        'Pisang', 'Apel', 'Jeruk', 'Pepaya', 'Mangga', 'Semangka', 'Melon'
    ],
    'kalori_per_100g': [
        130, 112, 150, 120, 118,  # Nasi & Karbohidrat
        250, 165, 280, 290, 200,  # Ayam & Bebek
        105, 96, 150, 130, 77,    # Ikan
        250, 200, 180, 180, 200,  # Daging Sapi & Kambing
        193, 150, 76, 110, 190,   # Tempe & Tahu
        154, 155, 180, 170, 158,  # Telur
        25, 45, 180, 150, 140,    # Sayuran
        19, 23, 150, 130, 120,    # Sayuran lainnya
        300, 250, 280, 260, 250,  # Mie & Nasi Goreng
        220, 180, 200, 150, 180,  # Sup & Kuah
        89, 52, 47, 43, 60, 30, 34 # Buah-buahan
    ],
    'protein_per_100g': [
        2.7, 2.3, 3.0, 2.0, 2.1,      # Nasi & Karbohidrat
        25.0, 31.0, 22.0, 18.0, 20.0, # Ayam & Bebek
        18.7, 20.1, 20.0, 25.0, 10.3, # Ikan
        26.0, 20.0, 18.0, 14.0, 18.0, # Daging Sapi & Kambing
        19.0, 16.0, 8.0, 12.0, 17.0,  # Tempe & Tahu
        11.0, 13.0, 12.0, 13.0, 13.0, # Telur
        2.0, 3.0, 8.0, 7.0, 6.0,      # Sayuran
        3.0, 2.9, 5.0, 4.0, 2.0,      # Sayuran lainnya
        12.0, 10.0, 8.0, 6.0, 9.0,    # Mie & Nasi Goreng
        15.0, 12.0, 20.0, 8.0, 12.0,  # Sup & Kuah
        1.1, 0.3, 0.9, 0.5, 0.8, 0.6, 0.5 # Buah-buahan
    ],
    'karbo_per_100g': [
        28.0, 22.0, 25.0, 26.0, 25.0,    # Nasi & Karbohidrat
        0.0, 0.0, 5.0, 0.0, 0.0,         # Ayam & Bebek
        0.0, 0.0, 0.0, 0.0, 0.0,         # Ikan
        8.0, 10.0, 6.0, 15.0, 2.0,       # Daging Sapi & Kambing
        9.0, 12.0, 1.9, 8.0, 10.0,       # Tempe & Tahu
        0.6, 1.1, 2.0, 1.5, 0.4,         # Telur
        5.0, 8.0, 15.0, 12.0, 18.0,      # Sayuran
        3.1, 3.6, 20.0, 8.0, 12.0,       # Sayuran lainnya
        45.0, 40.0, 35.0, 38.0, 42.0,    # Mie & Nasi Goreng
        20.0, 15.0, 12.0, 25.0, 18.0,    # Sup & Kuah
        23.0, 14.0, 12.0, 11.0, 15.0, 8.0, 8.0 # Buah-buahan
    ],
    'lemak_per_100g': [
        0.3, 0.9, 2.0, 0.1, 0.2,         # Nasi & Karbohidrat
        15.0, 3.6, 18.0, 22.0, 8.0,      # Ayam & Bebek
        2.7, 1.4, 4.8, 2.0, 0.8,         # Ikan
        15.0, 12.0, 10.0, 8.0, 12.0,     # Daging Sapi & Kambing
        11.0, 6.0, 4.8, 7.0, 12.0,       # Tempe & Tahu
        11.0, 11.0, 13.0, 12.0, 11.0,    # Telur
        0.2, 1.5, 10.0, 8.0, 6.0,        # Sayuran
        0.2, 0.4, 5.0, 3.0, 2.0,         # Sayuran lainnya
        8.0, 6.0, 12.0, 10.0, 11.0,      # Mie & Nasi Goreng
        8.0, 10.0, 12.0, 4.0, 9.0,       # Sup & Kuah
        0.3, 0.2, 0.1, 0.3, 0.4, 0.2, 0.2 # Buah-buahan
    ],
    'harga_per_porsi': [
        3000, 4000, 5000, 2500, 2500,    # Nasi & Karbohidrat
        8000, 9000, 12000, 15000, 12000, # Ayam & Bebek
        6000, 7000, 8000, 7000, 3000,    # Ikan
        15000, 12000, 13000, 5000, 8000, # Daging Sapi & Kambing
        2000, 3000, 1500, 2500, 2000,    # Tempe & Tahu
        3000, 2000, 4000, 3500, 5000,    # Telur
        3000, 4000, 6000, 5000, 4000,    # Sayuran
        2000, 2000, 5000, 3000, 3000,    # Sayuran lainnya
        7000, 6000, 8000, 6000, 7000,    # Mie & Nasi Goreng
        8000, 10000, 12000, 6000, 9000,  # Sup & Kuah
        2000, 5000, 3000, 3000, 4000, 5000, 6000 # Buah-buahan
    ],
    'kategori': [
        'karbohidrat', 'karbohidrat', 'karbohidrat', 'karbohidrat', 'karbohidrat',
        'protein', 'protein', 'protein', 'protein', 'protein',
        'protein', 'protein', 'protein', 'protein', 'protein',
        'protein', 'protein', 'protein', 'protein', 'protein',
        'protein', 'protein', 'protein', 'protein', 'protein',
        'protein', 'protein', 'protein', 'protein', 'protein',
        'sayuran', 'sayuran', 'lengkap', 'lengkap', 'lengkap',
        'sayuran', 'sayuran', 'sayuran', 'sayuran', 'sayuran',
        'lengkap', 'lengkap', 'lengkap', 'lengkap', 'lengkap',
        'lengkap', 'lengkap', 'lengkap', 'lengkap', 'lengkap',
        'buah', 'buah', 'buah', 'buah', 'buah', 'buah', 'buah'
    ],
    'ketersediaan': [
        'tinggi', 'sedang', 'sedang', 'tinggi', 'tinggi',
        'tinggi', 'tinggi', 'sedang', 'rendah', 'sedang',
        'tinggi', 'tinggi', 'sedang', 'sedang', 'tinggi',
        'sedang', 'rendah', 'rendah', 'tinggi', 'tinggi',
        'tinggi', 'sedang', 'tinggi', 'sedang', 'sedang',
        'tinggi', 'tinggi', 'sedang', 'sedang', 'sedang',
        'tinggi', 'tinggi', 'tinggi', 'tinggi', 'sedang',
        'tinggi', 'tinggi', 'sedang', 'sedang', 'sedang',
        'tinggi', 'tinggi', 'sedang', 'sedang', 'tinggi',
        'tinggi', 'sedang', 'sedang', 'sedang', 'sedang',
        'tinggi', 'tinggi', 'tinggi', 'tinggi', 'sedang', 'tinggi', 'sedang'
    ]
}

# Buat DataFrame
df_foods = pd.DataFrame(food_dataset)

# Dataset Testing - Profil Mahasiswa untuk Validasi
test_users = {
    'user_id': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    'nama': ['Andi', 'Budi', 'Citra', 'Dina', 'Eko', 'Fira', 'Gina', 'Haris', 'Ika', 'Joko'],
    'usia': [20, 21, 19, 22, 20, 21, 19, 23, 20, 22],
    'jenis_kelamin': ['L', 'L', 'P', 'P', 'L', 'P', 'P', 'L', 'P', 'L'],
    'tinggi_cm': [170, 175, 160, 165, 172, 158, 162, 180, 155, 168],
    'berat_kg': [65, 80, 50, 70, 85, 45, 55, 90, 48, 75],
    'aktivitas_jam': [2, 4, 1, 3, 5, 1.5, 2.5, 6, 2, 3.5],
    'budget_harian': [15000, 25000, 10000, 20000, 30000, 12000, 18000, 35000, 13000, 22000],
    'tujuan': ['maintain', 'turun', 'naik', 'maintain', 'turun', 'naik', 'maintain', 'turun', 'naik', 'maintain']
}

df_users = pd.DataFrame(test_users)

# Fungsi untuk menghitung BMI dan kategori
def calculate_bmi_category(berat, tinggi):
    bmi = berat / ((tinggi/100) ** 2)
    if bmi < 18.5:
        return bmi, 'underweight'
    elif bmi < 25:
        return bmi, 'normal'
    elif bmi < 30:
        return bmi, 'overweight'
    else:
        return bmi, 'obese'

# Tambahkan kolom BMI ke dataset users
df_users['bmi'] = df_users.apply(lambda x: calculate_bmi_category(x['berat_kg'], x['tinggi_cm'])[0], axis=1)
df_users['bmi_kategori'] = df_users.apply(lambda x: calculate_bmi_category(x['berat_kg'], x['tinggi_cm'])[1], axis=1)

# Fungsi untuk menghitung kebutuhan kalori dasar (BMR)
def calculate_bmr(berat, tinggi, usia, jenis_kelamin):
    if jenis_kelamin == 'L':  # Laki-laki
        return 88.362 + (13.397 * berat) + (4.799 * tinggi) - (5.677 * usia)
    else:  # Perempuan
        return 447.593 + (9.247 * berat) + (3.098 * tinggi) - (4.330 * usia)

# Faktor aktivitas
activity_factor = {
    1: 1.2,    # Sangat ringan (0-1 jam)
    2: 1.375,  # Ringan (1-2 jam)
    3: 1.55,   # Sedang (2-4 jam)
    4: 1.725,  # Berat (4-6 jam)
    5: 1.9     # Sangat berat (>6 jam)
}

def get_activity_factor(aktivitas_jam):
    if aktivitas_jam <= 1:
        return 1.2
    elif aktivitas_jam <= 2:
        return 1.375
    elif aktivitas_jam <= 4:
        return 1.55
    elif aktivitas_jam <= 6:
        return 1.725
    else:
        return 1.9

# Hitung kebutuhan kalori harian
df_users['bmr'] = df_users.apply(lambda x: calculate_bmr(x['berat_kg'], x['tinggi_cm'], x['usia'], x['jenis_kelamin']), axis=1)
df_users['aktivitas_faktor'] = df_users['aktivitas_jam'].apply(get_activity_factor)
df_users['kebutuhan_kalori'] = df_users['bmr'] * df_users['aktivitas_faktor']

# Sesuaikan berdasarkan tujuan
def adjust_calories_for_goal(kalori, tujuan):
    if tujuan == 'turun':
        return kalori * 0.8  # Defisit 20%
    elif tujuan == 'naik':
        return kalori * 1.2  # Surplus 20%
    else:
        return kalori

df_users['target_kalori'] = df_users.apply(lambda x: adjust_calories_for_goal(x['kebutuhan_kalori'], x['tujuan']), axis=1)

# Template untuk evaluasi sistem
evaluation_metrics = {
    'akurasi_kalori': [],
    'akurasi_protein': [],
    'budget_compliance': [],
    'user_satisfaction': []
}

# Fungsi untuk mengevaluasi rekomendasi
def evaluate_recommendation(user_data, recommendation):
    """
    Evaluasi akurasi rekomendasi sistem
    """
    # Akurasi kalori (toleransi 10%)
    kalori_diff = abs(recommendation['total_kalori'] - user_data['target_kalori'])
    kalori_accuracy = max(0, 100 - (kalori_diff / user_data['target_kalori'] * 100))
    
    # Akurasi protein (target 15-25% dari total kalori)
    protein_kalori = sum([meal['protein'] * 4 for meal in recommendation['meal_plan'].values()])
    protein_percentage = (protein_kalori / recommendation['total_kalori']) * 100
    protein_accuracy = max(0, 100 - abs(protein_percentage - 20))
    
    # Budget compliance
    budget_compliance = 100 if recommendation['total_cost'] <= user_data['budget_harian'] else 0
    
    return {
        'kalori_accuracy': kalori_accuracy,
        'protein_accuracy': protein_accuracy,
        'budget_compliance': budget_compliance
    }

# Contoh hasil testing
print("DATASET MAKANAN INDONESIA")
print("=" * 50)
print(f"Total makanan dalam database: {len(df_foods)}")
print(f"Kategori makanan: {df_foods['kategori'].unique()}")
print(f"Range harga: Rp{df_foods['harga_per_porsi'].min():,} - Rp{df_foods['harga_per_porsi'].max():,}")
print()

print("PROFIL MAHASISWA UNTUK TESTING")
print("=" * 50)
print(df_users[['nama', 'bmi', 'bmi_kategori', 'aktivitas_jam', 'target_kalori', 'budget_harian']].round(1))
print()

# Simpan dataset ke CSV
df_foods.to_csv('dataset_makanan.csv', index=False)
df_users.to_csv('dataset_users_test.csv', index=False)

print("Dataset berhasil disimpan ke:")
print("- dataset_makanan.csv")
print("- dataset_users_test.csv")

# Template untuk laporan
laporan_template = """
# LAPORAN PROYEK AKHIR
## SISTEM REKOMENDASI MAKANAN HARIAN UNTUK MAHASISWA BERDASARKAN TINGKAT AKTIVITAS DAN KONDISI TUBUH MENGGUNAKAN FUZZY LOGIC

### BAB I. PENDAHULUAN

#### 1.1 Latar Belakang
Mahasiswa sebagai kelompok masyarakat yang aktif memerlukan asupan nutrisi yang seimbang untuk mendukung aktivitas akademik dan fisik mereka. Namun, keterbatasan waktu, pengetahuan nutrisi, dan budget seringkali menjadi kendala dalam pemilihan makanan yang tepat. 

Sistem rekomendasi makanan berbasis fuzzy logic dapat membantu mahasiswa dalam memilih menu harian yang sesuai dengan kebutuhan individual mereka, dengan mempertimbangkan faktor-faktor seperti tingkat aktivitas, kondisi tubuh (BMI), budget, dan tujuan kesehatan.

#### 1.2 Rumusan Masalah
1. Bagaimana merancang sistem fuzzy logic untuk rekomendasi makanan mahasiswa?
2. Bagaimana akurasi sistem dalam memberikan rekomendasi yang sesuai kebutuhan?
3. Bagaimana tingkat kepuasan pengguna terhadap rekomendasi yang diberikan?

#### 1.3 Tujuan Penelitian
1. Mengembangkan sistem rekomendasi makanan menggunakan fuzzy logic
2. Mengevaluasi akurasi dan efektivitas sistem
3. Menganalisis tingkat kepuasan pengguna

### BAB II. TINJAUAN PUSTAKA

#### 2.1 Fuzzy Logic
[Isi dengan teori fuzzy logic, membership functions, inference engine, dll]

#### 2.2 Sistem Rekomendasi
[Isi dengan konsep dan jenis sistem rekomendasi]

#### 2.3 Nutrisi dan Kebutuhan Kalori
[Isi dengan teori gizi, BMR, faktor aktivitas, dll]

### BAB III. METODOLOGI

#### 3.1 Desain Sistem
[Diagram alur sistem, arsitektur fuzzy logic]

#### 3.2 Implementasi
[Detail implementasi kode, database, interface]

#### 3.3 Pengujian
[Metode testing, dataset, evaluasi]

### BAB IV. HASIL DAN PEMBAHASAN

#### 4.1 Implementasi Sistem
[Screenshot interface, penjelasan fitur]

#### 4.2 Hasil Pengujian
[Tabel hasil testing, grafik akurasi]

#### 4.3 Analisis Hasil
[Pembahasan hasil, kelebihan/kekurangan]

### BAB V. KESIMPULAN DAN SARAN

#### 5.1 Kesimpulan
[Ringkasan hasil penelitian]

#### 5.2 Saran
[Rekomendasi pengembangan lanjutan]
"""

print("\nTEMPLATE LAPORAN:")
print("=" * 50)
print(laporan_template)