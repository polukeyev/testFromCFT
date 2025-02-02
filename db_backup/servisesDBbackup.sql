PGDMP         8                y            servicesDB2    13.1    13.1 )    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16447    servicesDB2    DATABASE     X   CREATE DATABASE "servicesDB2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';
    DROP DATABASE "servicesDB2";
                postgres    false            �            1259    16558    cities    TABLE     l   CREATE TABLE public.cities (
    id integer NOT NULL,
    name character varying,
    country_id integer
);
    DROP TABLE public.cities;
       public         heap    postgres    false            �            1259    16556    cities_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cities_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cities_id_seq;
       public          postgres    false    203            �           0    0    cities_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cities_id_seq OWNED BY public.cities.id;
          public          postgres    false    202            �            1259    16545 	   countries    TABLE     W   CREATE TABLE public.countries (
    id integer NOT NULL,
    name character varying
);
    DROP TABLE public.countries;
       public         heap    postgres    false            �            1259    16543    countries_id_seq    SEQUENCE     �   CREATE SEQUENCE public.countries_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.countries_id_seq;
       public          postgres    false    201            �           0    0    countries_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.countries_id_seq OWNED BY public.countries.id;
          public          postgres    false    200            �            1259    16605    servicepoints_sevices    TABLE     t   CREATE TABLE public.servicepoints_sevices (
    serv_point_id integer NOT NULL,
    services_id integer NOT NULL
);
 )   DROP TABLE public.servicepoints_sevices;
       public         heap    postgres    false            �            1259    16574    services    TABLE     �   CREATE TABLE public.services (
    id integer NOT NULL,
    name character varying,
    address character varying,
    city_id integer,
    country_id integer
);
    DROP TABLE public.services;
       public         heap    postgres    false            �            1259    16572    services_id_seq    SEQUENCE     �   CREATE SEQUENCE public.services_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.services_id_seq;
       public          postgres    false    205            �           0    0    services_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.services_id_seq OWNED BY public.services.id;
          public          postgres    false    204            �            1259    16596    services_list    TABLE     d   CREATE TABLE public.services_list (
    id integer NOT NULL,
    name character varying NOT NULL
);
 !   DROP TABLE public.services_list;
       public         heap    postgres    false            �            1259    16594    services_list_id_seq    SEQUENCE     �   CREATE SEQUENCE public.services_list_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.services_list_id_seq;
       public          postgres    false    207            �           0    0    services_list_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.services_list_id_seq OWNED BY public.services_list.id;
          public          postgres    false    206            H           2604    16561 	   cities id    DEFAULT     f   ALTER TABLE ONLY public.cities ALTER COLUMN id SET DEFAULT nextval('public.cities_id_seq'::regclass);
 8   ALTER TABLE public.cities ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            G           2604    16548    countries id    DEFAULT     l   ALTER TABLE ONLY public.countries ALTER COLUMN id SET DEFAULT nextval('public.countries_id_seq'::regclass);
 ;   ALTER TABLE public.countries ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            I           2604    16577    services id    DEFAULT     j   ALTER TABLE ONLY public.services ALTER COLUMN id SET DEFAULT nextval('public.services_id_seq'::regclass);
 :   ALTER TABLE public.services ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            J           2604    16599    services_list id    DEFAULT     t   ALTER TABLE ONLY public.services_list ALTER COLUMN id SET DEFAULT nextval('public.services_list_id_seq'::regclass);
 ?   ALTER TABLE public.services_list ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            �          0    16558    cities 
   TABLE DATA           6   COPY public.cities (id, name, country_id) FROM stdin;
    public          postgres    false    203   �-       �          0    16545 	   countries 
   TABLE DATA           -   COPY public.countries (id, name) FROM stdin;
    public          postgres    false    201   �.       �          0    16605    servicepoints_sevices 
   TABLE DATA           K   COPY public.servicepoints_sevices (serv_point_id, services_id) FROM stdin;
    public          postgres    false    208   �.       �          0    16574    services 
   TABLE DATA           J   COPY public.services (id, name, address, city_id, country_id) FROM stdin;
    public          postgres    false    205   )/       �          0    16596    services_list 
   TABLE DATA           1   COPY public.services_list (id, name) FROM stdin;
    public          postgres    false    207   �/       �           0    0    cities_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cities_id_seq', 27, true);
          public          postgres    false    202            �           0    0    countries_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.countries_id_seq', 7, true);
          public          postgres    false    200            �           0    0    services_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.services_id_seq', 37, true);
          public          postgres    false    204            �           0    0    services_list_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.services_list_id_seq', 22, true);
          public          postgres    false    206            P           2606    16566    cities cities_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cities DROP CONSTRAINT cities_pkey;
       public            postgres    false    203            L           2606    16555    countries countries_name_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_name_key UNIQUE (name);
 F   ALTER TABLE ONLY public.countries DROP CONSTRAINT countries_name_key;
       public            postgres    false    201            N           2606    16553    countries countries_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.countries DROP CONSTRAINT countries_pkey;
       public            postgres    false    201            V           2606    16609 0   servicepoints_sevices servicepoints_sevices_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.servicepoints_sevices
    ADD CONSTRAINT servicepoints_sevices_pkey PRIMARY KEY (serv_point_id, services_id);
 Z   ALTER TABLE ONLY public.servicepoints_sevices DROP CONSTRAINT servicepoints_sevices_pkey;
       public            postgres    false    208    208            T           2606    16604     services_list services_list_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.services_list
    ADD CONSTRAINT services_list_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.services_list DROP CONSTRAINT services_list_pkey;
       public            postgres    false    207            R           2606    16582    services services_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.services DROP CONSTRAINT services_pkey;
       public            postgres    false    205            W           2606    16567    cities cities_country_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_country_id_fkey FOREIGN KEY (country_id) REFERENCES public.countries(id);
 G   ALTER TABLE ONLY public.cities DROP CONSTRAINT cities_country_id_fkey;
       public          postgres    false    203    3150    201            Z           2606    16610 >   servicepoints_sevices servicepoints_sevices_serv_point_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicepoints_sevices
    ADD CONSTRAINT servicepoints_sevices_serv_point_id_fkey FOREIGN KEY (serv_point_id) REFERENCES public.services(id);
 h   ALTER TABLE ONLY public.servicepoints_sevices DROP CONSTRAINT servicepoints_sevices_serv_point_id_fkey;
       public          postgres    false    208    205    3154            [           2606    16615 <   servicepoints_sevices servicepoints_sevices_services_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicepoints_sevices
    ADD CONSTRAINT servicepoints_sevices_services_id_fkey FOREIGN KEY (services_id) REFERENCES public.services_list(id);
 f   ALTER TABLE ONLY public.servicepoints_sevices DROP CONSTRAINT servicepoints_sevices_services_id_fkey;
       public          postgres    false    208    207    3156            X           2606    16583    services services_city_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.cities(id);
 H   ALTER TABLE ONLY public.services DROP CONSTRAINT services_city_id_fkey;
       public          postgres    false    3152    205    203            Y           2606    16588 !   services services_country_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_country_id_fkey FOREIGN KEY (country_id) REFERENCES public.countries(id);
 K   ALTER TABLE ONLY public.services DROP CONSTRAINT services_country_id_fkey;
       public          postgres    false    205    201    3150            �   �   x�%�Mn� ���9A���e��8i��J݌��*p������0O�s�C�C
�K\bv�KybWx7�C�Γv<�c4袷�&Ҭ.���i�[<�_��-�Ug,e���S���\���bغP�]	��Ơy�s�3�a4y6��Ƌv��%;68R��z-�02�\8j!�x5�%��A�:n`�1%�L�j����HI��Y��p)M�
o��L%�h��צ���O���'!��-X      �   ?   x�3�*-.�L�2�v�2�t/JM,Qp*�,I���2���/�ON��2��.
�r��qqq �?�      �   4   x�3��26��F`�L�p����8��$P؈ӂ��A�W� O1	{      �   �   x�E̱�0���+�H�(�2�hB�8�<���`+&����~r2�j�h�c�$�8&]!A��=�yOA��Ԃ�4T>gf���+Rܤ�@�hq�;�=^��y��ʽ8�Z%�/���V���A�_�߮d�p�]��ة{��� ��4w      �   �   x�E��
�@ �ݯ�/Ϸ���hacs�kr���=@���a�YCՉW�f=n�,����[���-qP�=�)\J|R')�&t���K�͠>�U��A7���KLa�p0�q��*{���� ��j�U2�&����3c     